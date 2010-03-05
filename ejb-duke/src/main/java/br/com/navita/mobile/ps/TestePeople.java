package br.com.navita.mobile.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import psft.pt8.joa.JOAException;
import PeopleSoft.Generated.CompIntfc.IDAsmAprov;
import PeopleSoft.Generated.CompIntfc.IDAsmAprovDExApresVw3;
import PeopleSoft.Generated.CompIntfc.IDAsmAprovDExApresVw3Collection;
import br.com.navita.mobile.domain.MobileBean;


public class TestePeople extends AbstractPeoplesoftService{

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(TestePeople.class.getName());
	
	

	public MobileBean execute(Map<String, Object> paramMap) {
		MobileBean bean = new MobileBean();
		String token = (String) paramMap.get("token");	
		log.log(Level.INFO,"Buscando sessao com token " + token);
		try {
			//***** Get Component Interface *****
			IDAsmAprov oDAsmAprov = null;
			String ciName;
			ciName = "D_ASM_APROV";
			oDAsmAprov = (IDAsmAprov) getComponentInterface(ciName, token, true);

			Aprovacao w1 = new Aprovacao();
			w1.setCreationDt(oDAsmAprov.getCreationDt());
			bean.setObject(w1);

			List<Supervisor> list = new ArrayList<Supervisor>();

			IDAsmAprovDExApresVw3Collection oDExApresVw3Collection;
			IDAsmAprovDExApresVw3 oDExApresVw3;
			oDExApresVw3Collection = oDAsmAprov.getDExApresVw3();
			for (int i16 = 0; i16 < oDExApresVw3Collection.getCount(); i16++) {
				oDExApresVw3 = oDExApresVw3Collection.item(i16);
				Supervisor s = new Supervisor();
				s.setName(oDExApresVw3.getName());
				s.setSupervisorId(oDExApresVw3.getSupervisorId());
				list.add(s);
			}

			bean.setList(list);			


		} catch (JOAException e) {
			log.log(Level.SEVERE,"Erro ao executar ci",e);
			bean.setMessage(e.getMessage());
			bean.setResultCode(1);
			return bean;
		} catch (Exception e) {
			log.log(Level.SEVERE,"Erro ao executar ci",e);
			bean.setMessage(e.getMessage());
			bean.setResultCode(1);
			return bean;
		}

		return bean;
	}

	


}
