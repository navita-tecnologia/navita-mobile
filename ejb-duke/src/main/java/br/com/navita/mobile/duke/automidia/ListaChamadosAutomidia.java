package br.com.navita.mobile.duke.automidia;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.httpclient.HttpException;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.duke.domain.Chamado;
import br.com.navita.mobile.util.HttpClientUtil;
import br.com.navita.mobile.xparse.Node;
import br.com.navita.mobile.xparse.NodeList;
import br.com.navita.mobile.xparse.Xparse;

public class ListaChamadosAutomidia extends BaseAutomidiaProcessor  {
	
	private static final long serialVersionUID = 1L;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss",new Locale("PT","BR"));

	
	@Override
	public MobileBean execute(Map<String, Object> params) {
		MobileBean bean = new MobileBean();
		String token = (String) params.get("token");
		try {
			token = URLEncoder.encode(token,"utf-8");
		} catch (UnsupportedEncodingException e1) {
			return getFailBean(1, e1);
		}

		String rawXML = null;
		try {
			rawXML = new HttpClientUtil().get(AUTOMIDIA_WS + "RequestsWaitingApproval?List=LISTREQAPROVSERVICE&Token=" + token, null);
		} catch (HttpException e1) {
			return getFailBean(1, e1);
		} catch (IOException e1) {
			return getFailBean(1, e1);
		}

		String hasErrorResult = assertNotOnError(rawXML);
		if(hasErrorResult != null){
			bean.setResultCode(1);
			bean.setMessage(hasErrorResult);			
			 return getFailBean(1,hasErrorResult );
		}
		
		Xparse xp = new Xparse();
		Node root = xp.parse(rawXML);
		Node chamadosNode=root.find("DataSet/diffgram/REQUESTAWAITINGAPPROVED", new int[]{1,1,1});
		if(chamadosNode==null){
			bean.setResultCode(1);
			bean.setMessage("Nenhum chamado pendente.");			
			return bean;
		}
		NodeList chamados = chamadosNode.getChildNodes();

		ArrayList<Chamado> listChamados = new ArrayList<Chamado>();	

		for(int n=0; n<chamados.length();n++){
			Node chamado = (Node) chamados.elementAt(n);

			if("REQUEST".equals(chamado.name)){
				Chamado listchamado = new Chamado(chamado.getChildValue("REQUEST"),chamado.getChildValue("CLIENT"));
				listchamado.setResumo(chamado.getChildValue("ABSTRACT"));
				String strAbertura = chamado.getChildValue("OPENDATE");
				if(strAbertura!=null){
					strAbertura = strAbertura.replace("T", " ");
					strAbertura = strAbertura.substring(0,"yyyy-MM-dd hh:mm:ss".length());
					Date abertura = null;
					try {
						sdf.applyPattern("yyyy-MM-dd hh:mm:ss");
						abertura = sdf.parse(strAbertura);
					} catch (ParseException e) {

					}
					sdf.applyPattern("dd/MM/yyyy kk:mm");
					if(abertura != null){
						listchamado.setAbertura(sdf.format(abertura));
					}
				}
				listchamado.setPrioridade(chamado.getChildValue("RPRIORITY"));
				listchamado.setAnalista(chamado.getChildValue("CURRANAL"));
				listchamado.setStatus(chamado.getChildValue("RSTATUS"));
				listchamado.setDescricao(chamado.getChildValue("DESCRIPT"));
				String usuarioAtendido = chamado.getChildValue("REQUESTOR");
				listchamado.setUsuarioAtendido(usuarioAtendido==null?"---":usuarioAtendido);

				listChamados.add(listchamado);
			}
		}

		bean.setResultCode(0);
		bean.setToken(token);
		bean.setList(listChamados);
		bean.setMessage("Success ListaChamadosAutomidia");
		return bean;
	}


	


	
}
