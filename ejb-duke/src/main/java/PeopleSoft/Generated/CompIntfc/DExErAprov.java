
//*****************************************************************
//* 
//* DExErAprov.java (generated)
//* 
//* Automatically generated at Wed Mar 03 14:27:00 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DExErAprov implements IDExErAprov 
  {
  public DExErAprov(IObject oThis) { m_oThis = oThis; }

  public String getTransactionId() throws JOAException {
    return (String)m_oThis.getProperty("TRANSACTION_ID");
 }

  public void setTransactionId(String inTransactionId) throws JOAException {
    m_oThis.setProperty("TRANSACTION_ID", inTransactionId);
 }

  public String getPersonName() throws JOAException {
    return (String)m_oThis.getProperty("PERSON_NAME");
 }

  public void setPersonName(String inPersonName) throws JOAException {
    m_oThis.setProperty("PERSON_NAME", inPersonName);
 }

  public String getPbApprove() throws JOAException {
    return (String)m_oThis.getProperty("PB_APPROVE");
 }

  public void setPbApprove(String inPbApprove) throws JOAException {
    m_oThis.setProperty("PB_APPROVE", inPbApprove);
 }

  public String getReturnToEe() throws JOAException {
    return (String)m_oThis.getProperty("RETURN_TO_EE");
 }

  public void setReturnToEe(String inReturnToEe) throws JOAException {
    m_oThis.setProperty("RETURN_TO_EE", inReturnToEe);
 }

  public String getPurposeTypeCd() throws JOAException {
    return (String)m_oThis.getProperty("PURPOSE_TYPE_CD");
 }

  public void setPurposeTypeCd(String inPurposeTypeCd) throws JOAException {
    m_oThis.setProperty("PURPOSE_TYPE_CD", inPurposeTypeCd);
 }

  public String getDescrLocation() throws JOAException {
    return (String)m_oThis.getProperty("DESCR_LOCATION");
 }

  public void setDescrLocation(String inDescrLocation) throws JOAException {
    m_oThis.setProperty("DESCR_LOCATION", inDescrLocation);
 }

  public String getComments0() throws JOAException {
    return (String)m_oThis.getProperty("COMMENTS_0");
 }

  public void setComments0(String inComments0) throws JOAException {
    m_oThis.setProperty("COMMENTS_0", inComments0);
 }

  public String getReferenceId() throws JOAException {
    return (String)m_oThis.getProperty("REFERENCE_ID");
 }

  public void setReferenceId(String inReferenceId) throws JOAException {
    m_oThis.setProperty("REFERENCE_ID", inReferenceId);
 }

  public String getSheetName() throws JOAException {
    return (String)m_oThis.getProperty("SHEET_NAME");
 }

  public void setSheetName(String inSheetName) throws JOAException {
    m_oThis.setProperty("SHEET_NAME", inSheetName);
 }

  public String getAccountingDt() throws JOAException {
    return (String)m_oThis.getProperty("ACCOUNTING_DT");
 }

  public void setAccountingDt(String inAccountingDt) throws JOAException {
    m_oThis.setProperty("ACCOUNTING_DT", inAccountingDt);
 }

  public String getComments() throws JOAException {
    return (String)m_oThis.getProperty("COMMENTS");
 }

  public void setComments(String inComments) throws JOAException {
    m_oThis.setProperty("COMMENTS", inComments);
 }

  public String getSupervisorId() throws JOAException {
    return (String)m_oThis.getProperty("SUPERVISOR_ID");
 }

  public void setSupervisorId(String inSupervisorId) throws JOAException {
    m_oThis.setProperty("SUPERVISOR_ID", inSupervisorId);
 }

  public String getDExEncamSup() throws JOAException {
    return (String)m_oThis.getProperty("D_EX_ENCAM_SUP");
 }

  public void setDExEncamSup(String inDExEncamSup) throws JOAException {
    m_oThis.setProperty("D_EX_ENCAM_SUP", inDExEncamSup);
 }

  public String getButton() throws JOAException {
    return (String)m_oThis.getProperty("BUTTON");
 }

  public void setButton(String inButton) throws JOAException {
    m_oThis.setProperty("BUTTON", inButton);
 }

  public String getForwardSw() throws JOAException {
    return (String)m_oThis.getProperty("FORWARD_SW");
 }

  public void setForwardSw(String inForwardSw) throws JOAException {
    m_oThis.setProperty("FORWARD_SW", inForwardSw);
 }

  public IDExErAprovExSheetLineCollection getExSheetLine() throws JOAException {
    return (IDExErAprovExSheetLineCollection)m_oThis.getProperty("EX_SHEET_LINE");
 }

  public String getSheetId() throws JOAException {
    return (String)m_oThis.getProperty("SHEET_ID");
 }

  public void setSheetId(String inSheetId) throws JOAException {
    m_oThis.setProperty("SHEET_ID", inSheetId);
 }

  public String getEmplid() throws JOAException {
    return (String)m_oThis.getProperty("EMPLID");
 }

  public void setEmplid(String inEmplid) throws JOAException {
    m_oThis.setProperty("EMPLID", inEmplid);
 }

  public boolean getInteractiveMode() throws JOAException {
    return ((Boolean)m_oThis.getProperty("InteractiveMode")).booleanValue();
 }

  public void setInteractiveMode(boolean inInteractiveMode) throws JOAException {
    m_oThis.setProperty("InteractiveMode", new Boolean(inInteractiveMode));
 }

  public boolean getGetHistoryItems() throws JOAException {
    return ((Boolean)m_oThis.getProperty("GetHistoryItems")).booleanValue();
 }

  public void setGetHistoryItems(boolean inGetHistoryItems) throws JOAException {
    m_oThis.setProperty("GetHistoryItems", new Boolean(inGetHistoryItems));
 }

  public boolean getEditHistoryItems() throws JOAException {
    return ((Boolean)m_oThis.getProperty("EditHistoryItems")).booleanValue();
 }

  public void setEditHistoryItems(boolean inEditHistoryItems) throws JOAException {
    m_oThis.setProperty("EditHistoryItems", new Boolean(inEditHistoryItems));
 }

  public String getComponentName() throws JOAException {
    return (String)m_oThis.getProperty("ComponentName");
 }

  public String getCompIntfcName() throws JOAException {
    return (String)m_oThis.getProperty("CompIntfcName");
 }

  public String getMarket() throws JOAException {
    return (String)m_oThis.getProperty("Market");
 }

  public String getDescription() throws JOAException {
    return (String)m_oThis.getProperty("Description");
 }

  public boolean getGetDummyRows() throws JOAException {
    return ((Boolean)m_oThis.getProperty("GetDummyRows")).booleanValue();
 }

  public void setGetDummyRows(boolean inGetDummyRows) throws JOAException {
    m_oThis.setProperty("GetDummyRows", new Boolean(inGetDummyRows));
 }

  public boolean getStopOnFirstError() throws JOAException {
    return ((Boolean)m_oThis.getProperty("StopOnFirstError")).booleanValue();
 }

  public void setStopOnFirstError(boolean inStopOnFirstError) throws JOAException {
    m_oThis.setProperty("StopOnFirstError", new Boolean(inStopOnFirstError));
 }

  public ICompIntfcPropertyInfoCollection getPropertyInfoCollection() throws JOAException {
    return (ICompIntfcPropertyInfoCollection)m_oThis.getProperty("PropertyInfoCollection");
 }

  public ICompIntfcPropertyInfoCollection getCreateKeyInfoCollection() throws JOAException {
    return (ICompIntfcPropertyInfoCollection)m_oThis.getProperty("CreateKeyInfoCollection");
 }

  public ICompIntfcPropertyInfoCollection getGetKeyInfoCollection() throws JOAException {
    return (ICompIntfcPropertyInfoCollection)m_oThis.getProperty("GetKeyInfoCollection");
 }

  public ICompIntfcPropertyInfoCollection getFindKeyInfoCollection() throws JOAException {
    return (ICompIntfcPropertyInfoCollection)m_oThis.getProperty("FindKeyInfoCollection");
 }

  public boolean get() throws JOAException {
    Object[] args = new Object[0];
    return ((Boolean)(m_oThis.invokeMethod("Get", args))).booleanValue();
    }

  public boolean save() throws JOAException {
    Object[] args = new Object[0];
    return ((Boolean)(m_oThis.invokeMethod("Save", args))).booleanValue();
    }

  public boolean cancel() throws JOAException {
    Object[] args = new Object[0];
    return ((Boolean)(m_oThis.invokeMethod("Cancel", args))).booleanValue();
    }

  public IDExErAprovCollection find() throws JOAException {
    Object[] args = new Object[0];
    return (IDExErAprovCollection)m_oThis.invokeMethod("Find", args);
    }

  public Object getPropertyByName(String Name) throws JOAException {
    Object[] args = new Object[1];
    args[0] = Name;
    return (Object)m_oThis.invokeMethod("GetPropertyByName", args);
    }

  public long setPropertyByName(String Name, Object Value) throws JOAException {
    Object[] args = new Object[2];
    args[0] = Name;
    args[1] = Value;
    return ((Long)(m_oThis.invokeMethod("SetPropertyByName", args))).longValue();
    }

  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException {
    Object[] args = new Object[1];
    args[0] = Name;
    return (ICompIntfcPropertyInfo)m_oThis.invokeMethod("GetPropertyInfoByName", args);
    }

  IObject m_oThis;
  }
