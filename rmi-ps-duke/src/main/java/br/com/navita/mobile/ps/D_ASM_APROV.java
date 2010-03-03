//===>
//This is a dynamically generated Java template to be used only as a helper
//to the application developer.
//You need to replace all references to '<*>' OR default values with  references to
//Java variables.


package br.com.navita.mobile.ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import PeopleSoft.Generated.CompIntfc.IDAsmAprov;
import PeopleSoft.Generated.CompIntfc.IDAsmAprovDAsmApres;
import PeopleSoft.Generated.CompIntfc.IDAsmAprovDAsmApresCollection;
import PeopleSoft.Generated.CompIntfc.IDAsmAprovDAsmCntrctVw;
import PeopleSoft.Generated.CompIntfc.IDAsmAprovDAsmCntrctVwCollection;
import PeopleSoft.Generated.CompIntfc.IDAsmAprovDAsmVendorVw;
import PeopleSoft.Generated.CompIntfc.IDAsmAprovDAsmVendorVwCollection;
import PeopleSoft.Generated.CompIntfc.IDAsmAprovDExApresVw3;
import PeopleSoft.Generated.CompIntfc.IDAsmAprovDExApresVw3Collection;

import psft.pt8.joa.API;
import psft.pt8.joa.IPSMessage;
import psft.pt8.joa.IPSMessageCollection;
import psft.pt8.joa.ISession;

public class D_ASM_APROV {
	public static ISession oSession;

	public static void ErrorHandler() {
		//***** Display PeopleSoft Error Messages *****
		if (oSession.getErrorPending() || oSession.getWarningPending()) {
			IPSMessageCollection oPSMessageCollection;
			IPSMessage oPSMessage;

			oPSMessageCollection = oSession.getPSMessages();
			for (int i = 0; i < oPSMessageCollection.getCount(); i++) {
				oPSMessage = oPSMessageCollection.item(i);
				if (oPSMessage != null)
					System.out.println("(" + oPSMessage.getMessageSetNumber() + "," + oPSMessage.getMessageSetNumber() + ") : " + oPSMessage.getText());
			}
			//***** Done processing messages in the collection; OK to delete *****
			oPSMessageCollection.deleteAll();
		}
	}

	public static void main (String args[]) {
		try {
			//***** Set Connect Parameters *****
			String strServerName, strServerPort, strAppServerPath;
			String strUserID, strPassword;
			BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));

			//Get Application Server Machine Name
			System.out.print("Enter Application Server Machine Name: ");
			strServerName = inData.readLine();

			//Get Application Server Port Number
			System.out.print("Enter Application Server Port Number: ");
			strServerPort = inData.readLine();

			//Get PeopleSoft UserID
			System.out.print("Enter PeopleSoft UserID: ");
			strUserID = inData.readLine();

			//Get PeopleSoft UserID Password
			System.out.print("Enter PeopleSoft UserID Password: ");
			strPassword = inData.readLine();

			if (strServerName.length() == 0 ||
					strServerPort.length() == 0 ||
					strUserID.length() == 0 ||
					strPassword.length() == 0) {
				System.out.println("\nConnect information provided is incomplete");
				return;
			}

			//Build Application Server Path
			strAppServerPath = strServerName + ":" + strServerPort;

			//***** Create PeopleSoft Session Object *****
			oSession = API.createSession();

			//***** Connect to the App Server *****
			if (!oSession.connect(1, strAppServerPath, strUserID, strPassword, null)) {
				System.out.println("\nUnable to Connect to Application Server.");
				ErrorHandler();
				return;
			}

			//***** Get Component Interface *****
			IDAsmAprov oDAsmAprov;
			String ciName;
			ciName = "D_ASM_APROV";
			oDAsmAprov = (IDAsmAprov) oSession.getCompIntfc(ciName);
			if (oDAsmAprov == null) {
				System.out.println("\nUnable to Get Component Interface " + ciName);
				ErrorHandler();
				return;
			}

			//***** Set the Component Interface Mode *****
			oDAsmAprov.setInteractiveMode(false);
			oDAsmAprov.setGetHistoryItems(true);
			oDAsmAprov.setEditHistoryItems(false);

			//***** Set Component Interface Get/Create Keys *****

			//***** Execute Get *****
			if (!oDAsmAprov.get()) {
				System.out.println("\nNo rows exist for the specified keys.\nFailed to get the Component Interface.");
				ErrorHandler();
				return;
			}


			//***** BEGIN:  Set/Get Component Interface Properties *****

			//***** Set Level 0 Properties *****
			System.out.println("oDAsmAprov.CreationDt: " + oDAsmAprov.getCreationDt());
			System.out.println("oDAsmAprov.Descr254: " + oDAsmAprov.getDescr254());
			System.out.println("oDAsmAprov.Descr254Mixed: " + oDAsmAprov.getDescr254Mixed());
			System.out.println("oDAsmAprov.DeadlineDt: " + oDAsmAprov.getDeadlineDt());
			System.out.println("oDAsmAprov.DAsmAmtTtl: " + oDAsmAprov.getDAsmAmtTtl());
			System.out.println("oDAsmAprov.Comments: " + oDAsmAprov.getComments());
			//oDAsmAprov.setComments(<*>);

			//Set/Get D_EX_APRES_VW3 Collection Field Properties -- Parent: PS_ROOT Collection
			IDAsmAprovDExApresVw3Collection oDExApresVw3Collection;
			IDAsmAprovDExApresVw3 oDExApresVw3;
			oDExApresVw3Collection = oDAsmAprov.getDExApresVw3();
			for (int i16 = 0; i16 < oDExApresVw3Collection.getCount(); i16++) {
				oDExApresVw3 = oDExApresVw3Collection.item(i16);
				System.out.println("oDExApresVw3.SupervisorId: " + oDExApresVw3.getSupervisorId());
				//oDExApresVw3.setSupervisorId(<*>);
				System.out.println("oDExApresVw3.Name: " + oDExApresVw3.getName());
				//oDExApresVw3.setName(<*>);
			}

			//Set/Get D_ASM_APRES Collection Field Properties -- Parent: PS_ROOT Collection
			IDAsmAprovDAsmApresCollection oDAsmApresCollection;
			IDAsmAprovDAsmApres oDAsmApres;
			oDAsmApresCollection = oDAsmAprov.getDAsmApres();
			for (int i19 = 0; i19 < oDAsmApresCollection.getCount(); i19++) {
				oDAsmApres = oDAsmApresCollection.item(i19);
				System.out.println("oDAsmApres.SupervisorId: " + oDAsmApres.getSupervisorId());
				//oDAsmApres.setSupervisorId(<*>);
				System.out.println("oDAsmApres.Sel: " + oDAsmApres.getSel());
				//oDAsmApres.setSel(<*>);
				System.out.println("oDAsmApres.ApprovePb: " + oDAsmApres.getApprovePb());
				//oDAsmApres.setApprovePb(<*>);
				System.out.println("oDAsmApres.DenyPb: " + oDAsmApres.getDenyPb());
				//oDAsmApres.setDenyPb(<*>);
				System.out.println("oDAsmApres.DAsmAmtTtl: " + oDAsmApres.getDAsmAmtTtl());
				//oDAsmApres.setDAsmAmtTtl(<*>);
				System.out.println("oDAsmApres.VendorName1: " + oDAsmApres.getVendorName1());
				//oDAsmApres.setVendorName1(<*>);
				System.out.println("oDAsmApres.SendContactId: " + oDAsmApres.getSendContactId());
				//oDAsmApres.setSendContactId(<*>);
				System.out.println("oDAsmApres.ForwardSw: " + oDAsmApres.getForwardSw());
				//oDAsmApres.setForwardSw(<*>);
				System.out.println("oDAsmApres.Emplid: " + oDAsmApres.getEmplid());
				//oDAsmApres.setEmplid(<*>);
				System.out.println("oDAsmApres.BusinessUnit1: " + oDAsmApres.getBusinessUnit1());
				System.out.println("oDAsmApres.DNumAsm: " + oDAsmApres.getDNumAsm());
			}

			//Set/Get D_ASM_CNTRCT_VW Collection Field Properties -- Parent: PS_ROOT Collection
			IDAsmAprovDAsmCntrctVwCollection oDAsmCntrctVwCollection;
			IDAsmAprovDAsmCntrctVw oDAsmCntrctVw;
			oDAsmCntrctVwCollection = oDAsmAprov.getDAsmCntrctVw();
			for (int i121 = 0; i121 < oDAsmCntrctVwCollection.getCount(); i121++) {
				oDAsmCntrctVw = oDAsmCntrctVwCollection.item(i121);
				System.out.println("oDAsmCntrctVw.CntrctId3: " + oDAsmCntrctVw.getCntrctId3());
				System.out.println("oDAsmCntrctVw.CntrctExpireDt3: " + oDAsmCntrctVw.getCntrctExpireDt3());
				System.out.println("oDAsmCntrctVw.DRespons1: " + oDAsmCntrctVw.getDRespons1());
				System.out.println("oDAsmCntrctVw.DGestor1: " + oDAsmCntrctVw.getDGestor1());
			}

			//Set/Get D_ASM_VENDOR_VW Collection Field Properties -- Parent: PS_ROOT Collection
			IDAsmAprovDAsmVendorVwCollection oDAsmVendorVwCollection;
			IDAsmAprovDAsmVendorVw oDAsmVendorVw;
			oDAsmVendorVwCollection = oDAsmAprov.getDAsmVendorVw();
			for (int i126 = 0; i126 < oDAsmVendorVwCollection.getCount(); i126++) {
				oDAsmVendorVw = oDAsmVendorVwCollection.item(i126);
				System.out.println("oDAsmVendorVw.DNumAsm1: " + oDAsmVendorVw.getDNumAsm1());
				System.out.println("oDAsmVendorVw.CreationDt1: " + oDAsmVendorVw.getCreationDt1());
				System.out.println("oDAsmVendorVw.DAsmAmtTtl1: " + oDAsmVendorVw.getDAsmAmtTtl1());
			}

			//***** END:  Set Component Interface Properties *****

			//***** Execute Standard and Custom Methods *****
			//***** Execute Save *****
			//if (!oDAsmAprov.save()) {
			//	System.out.println("Unable to Save Component Interface");
			//	ErrorHandler();
			//	return;
			//}

			//***** Execute Cancel *****
			//if (!oDAsmAprov.cancel()) {
			//	System.out.println("Unable to Cancel Component Interface");
			//	ErrorHandler();
			//	return;
			//}


			//***** Disconnect from the App Server *****
			oSession.disconnect();
			return;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error occurred: ");
			ErrorHandler();
		}
	}
}
