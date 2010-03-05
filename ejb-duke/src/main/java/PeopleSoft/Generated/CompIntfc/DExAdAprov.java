
//*****************************************************************
//* 
//* DExAdAprov.java (generated)
//* 
//* Automatically generated at Wed Mar 03 14:27:00 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DExAdAprov implements IDExAdAprov 
  {
  public DExAdAprov(IObject oThis) { m_oThis = oThis; }

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

  public String getComments0() throws JOAException {
    return (String)m_oThis.getProperty("COMMENTS_0");
 }

  public void setComments0(String inComments0) throws JOAException {
    m_oThis.setProperty("COMMENTS_0", inComments0);
 }

  public String getPbReturn() throws JOAException {
    return (String)m_oThis.getProperty("PB_RETURN");
 }

  public void setPbReturn(String inPbReturn) throws JOAException {
    m_oThis.setProperty("PB_RETURN", inPbReturn);
 }

  public String getLastUpdateDt() throws JOAException {
    return (String)m_oThis.getProperty("LAST_UPDATE_DT");
 }

  public void setLastUpdateDt(String inLastUpdateDt) throws JOAException {
    m_oThis.setProperty("LAST_UPDATE_DT", inLastUpdateDt);
 }

  public String getOpridLastUpdt() throws JOAException {
    return (String)m_oThis.getProperty("OPRID_LAST_UPDT");
 }

  public void setOpridLastUpdt(String inOpridLastUpdt) throws JOAException {
    m_oThis.setProperty("OPRID_LAST_UPDT", inOpridLastUpdt);
 }

  public String getReferenceId() throws JOAException {
    return (String)m_oThis.getProperty("REFERENCE_ID");
 }

  public void setReferenceId(String inReferenceId) throws JOAException {
    m_oThis.setProperty("REFERENCE_ID", inReferenceId);
 }

  public String getAdvanceName() throws JOAException {
    return (String)m_oThis.getProperty("ADVANCE_NAME");
 }

  public void setAdvanceName(String inAdvanceName) throws JOAException {
    m_oThis.setProperty("ADVANCE_NAME", inAdvanceName);
 }

  public String getPostStatusEx() throws JOAException {
    return (String)m_oThis.getProperty("POST_STATUS_EX");
 }

  public void setPostStatusEx(String inPostStatusEx) throws JOAException {
    m_oThis.setProperty("POST_STATUS_EX", inPostStatusEx);
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

  public String getCurrencyCd() throws JOAException {
    return (String)m_oThis.getProperty("CURRENCY_CD");
 }

  public void setCurrencyCd(String inCurrencyCd) throws JOAException {
    m_oThis.setProperty("CURRENCY_CD", inCurrencyCd);
 }

  public String getPbApprove() throws JOAException {
    return (String)m_oThis.getProperty("PB_APPROVE");
 }

  public void setPbApprove(String inPbApprove) throws JOAException {
    m_oThis.setProperty("PB_APPROVE", inPbApprove);
 }

  public String getPbReview() throws JOAException {
    return (String)m_oThis.getProperty("PB_REVIEW");
 }

  public void setPbReview(String inPbReview) throws JOAException {
    m_oThis.setProperty("PB_REVIEW", inPbReview);
 }

  public String getPbSubmit() throws JOAException {
    return (String)m_oThis.getProperty("PB_SUBMIT");
 }

  public void setPbSubmit(String inPbSubmit) throws JOAException {
    m_oThis.setProperty("PB_SUBMIT", inPbSubmit);
 }

  public String getReturnToEe() throws JOAException {
    return (String)m_oThis.getProperty("RETURN_TO_EE");
 }

  public void setReturnToEe(String inReturnToEe) throws JOAException {
    m_oThis.setProperty("RETURN_TO_EE", inReturnToEe);
 }

  public BigDecimal getTotalAdvAmt() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("TOTAL_ADV_AMT")));
 }

  public void setTotalAdvAmt(BigDecimal inTotalAdvAmt) throws JOAException {
    m_oThis.setProperty("TOTAL_ADV_AMT", inTotalAdvAmt.toString());
 }

  public String getPurposeTypeCd() throws JOAException {
    return (String)m_oThis.getProperty("PURPOSE_TYPE_CD");
 }

  public void setPurposeTypeCd(String inPurposeTypeCd) throws JOAException {
    m_oThis.setProperty("PURPOSE_TYPE_CD", inPurposeTypeCd);
 }

  public String getSupervisorId() throws JOAException {
    return (String)m_oThis.getProperty("SUPERVISOR_ID");
 }

  public void setSupervisorId(String inSupervisorId) throws JOAException {
    m_oThis.setProperty("SUPERVISOR_ID", inSupervisorId);
 }

  public IDExAdAprovExAdvLineCollection getExAdvLine() throws JOAException {
    return (IDExAdAprovExAdvLineCollection)m_oThis.getProperty("EX_ADV_LINE");
 }

  public String getAdvanceId() throws JOAException {
    return (String)m_oThis.getProperty("ADVANCE_ID");
 }

  public void setAdvanceId(String inAdvanceId) throws JOAException {
    m_oThis.setProperty("ADVANCE_ID", inAdvanceId);
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

  public IDExAdAprovCollection find() throws JOAException {
    Object[] args = new Object[0];
    return (IDExAdAprovCollection)m_oThis.invokeMethod("Find", args);
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
