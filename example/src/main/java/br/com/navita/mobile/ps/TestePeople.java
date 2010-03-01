package br.com.navita.mobile.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import psft.pt8.joa.JOAException;
import PeopleSoft.Generated.CompIntfc.IDAsmAprov;
import PeopleSoft.Generated.CompIntfc.IDAsmAprovDExApresVw3;
import PeopleSoft.Generated.CompIntfc.IDAsmAprovDExApresVw3Collection;
import br.com.navita.mobile.console.deployable.DynamicExecutor;
import br.com.navita.mobile.console.domain.MobileBean;


public class TestePeople implements DynamicExecutor {

	public MobileBean execute(Map<String, Object> paramMap) {
		MobileBean bean = new MobileBean();
		String token = (String) paramMap.get("token");

		
		try {
			

			//***** Get Component Interface *****
			IDAsmAprov oDAsmAprov = null;
			String ciName;
			ciName = "D_ASM_APROV";
//			oDAsmAprov = (IDAsmAprov) PeopleSoftUtil.getComponentInterface(ciName, token);
//			if (oDAsmAprov == null) {			
//				PeopleSoftUtil.errorHandler("Unable to Get Component Interface " + ciName, token);			
//			}

			//***** Set the Component Interface Mode *****
			oDAsmAprov.setInteractiveMode(false);
			oDAsmAprov.setGetHistoryItems(true);
			oDAsmAprov.setEditHistoryItems(false);

			//***** Execute Get *****
			if (!oDAsmAprov.get()) {				
				//PeopleSoftUtil.errorHandler("\nNo rows exist for the specified keys.\nFailed to get the Component Interface.",token);				
			}

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
			bean.setMessage(e.getMessage());
			bean.setResultCode(1);
			return bean;
		} catch (Exception e) {
			bean.setMessage(e.getMessage());
			bean.setResultCode(1);
			return bean;
		}

		return bean;
	}



}
