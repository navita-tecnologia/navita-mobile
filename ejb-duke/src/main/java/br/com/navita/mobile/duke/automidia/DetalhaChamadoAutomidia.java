package br.com.navita.mobile.duke.automidia;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpException;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.duke.domain.Chamado;
import br.com.navita.mobile.duke.domain.FormPair;
import br.com.navita.mobile.util.HttpClientUtil;
import br.com.navita.mobile.xparse.Node;
import br.com.navita.mobile.xparse.NodeList;
import br.com.navita.mobile.xparse.Xparse;

public class DetalhaChamadoAutomidia extends BaseAutomidiaProcessor {
	
	
	private static final long serialVersionUID = 1L;
	private String listParam = "LISTA";	
	
	
	@Override
	public MobileBean execute(Map<String, Object> params) {
		MobileBean bean = new MobileBean();
		String token = (String) params.get("token");
		try {
			token = URLEncoder.encode(token,"utf-8");
		} catch (UnsupportedEncodingException e) {
			return getFailBean(1, e);
		}
		
		String numeroChamado = (String) params.get("numeroChamado");
		

		String rawXML = null;
		try {
			rawXML = new HttpClientUtil().get(AUTOMIDIA_WS + "RequestDetails?Token="+token+"&List="+listParam+"&Request=" + numeroChamado, null);
		} catch (HttpException e) {
			return getFailBean(1, e);
		} catch (IOException e) {
			return getFailBean(1, e);
		}

		String hasErrorResult = assertNotOnError(rawXML);
		if(hasErrorResult != null){
			return getFailBean(1, hasErrorResult);			
		}
		
		Xparse xp = new Xparse();
		Node root = xp.parse(rawXML);
				
		
		Node chamadoNode=root.find("DataSet/diffgram/DETAILSREQUEST/REQUEST", new int[]{1,1,1,1});
		if(chamadoNode==null){
			return getFailBean(1, "Falha ao fazer parse.");			
		}
		
		//// FORM parse
		List<FormPair> formData = null;
		HashMap<String, String> labels = new HashMap<String, String>();
		Node choices = root.find("DataSet/schema/element/complexType/choice", new int[]{1,1,1,1,1});
		NodeList choiceList = choices.getChildNodes();
		Node labelNodes = null;
		for(int i=0;i<choiceList.length();i++){
			Node element = (Node) choiceList.elementAt(i);
			if("xs:element".equals( element.name) && "FORM".equals(element.attributes.get("name"))){
				labelNodes = element.find("complexType/sequence", new int[]{1,1});
			}
		}

		if(labelNodes!=null){
			NodeList list = labelNodes.getChildNodes();
			for(int i = 0;i<list.length();i++){
				Node n = (Node) list.elementAt(i);
				if("xs:element".equals( n.name)){				
					labels.put(n.attributes.get("name"), n.attributes.get("msdata:Caption"));				
				}			
			}
		}
		
		Node formNode=root.find("DataSet/diffgram/DETAILSREQUEST/FORM", new int[]{1,1,1,1});
		if(formNode!=null){
			formData = new ArrayList<FormPair>();
			NodeList formList = formNode.getChildNodes();
			for(int i = 0;i<formList.length();i++){
				Node n = (Node) formList.elementAt(i);
				String v = labels.get(n.name);
				if(v!=null){
					formData.add(new FormPair(v,n.getCharacters()));					
				}
			}
			
		}		
		//end form parse
		
		
		Chamado chamado = new Chamado(chamadoNode.getChildValue("REQUEST"),chamadoNode.getChildValue("CLIENT"));//
		chamado.setPrioridade("");
		chamado.setAnalista(chamadoNode.getChildValue("CURRANAL"));
		chamado.setStatus(chamadoNode.getChildValue("RSTATUS"));//
		chamado.setDescricao(chamadoNode.getChildValue("DESCRIPT"));//
		chamado.setResumo(chamadoNode.getChildValue("ABSTRACT"));//
		String usuarioAtendido = chamadoNode.getChildValue("REQUESTOR");//
		chamado.setUsuarioAtendido(usuarioAtendido==null?"---":usuarioAtendido);	
		
		chamado.setFormData(formData);
		
		
		

		bean.setResultCode(0);
		bean.setToken(token);
		bean.setObject(chamado);
		
		bean.setMessage("Success DetalhaChamado");
		return bean;
		

	}

	

}
