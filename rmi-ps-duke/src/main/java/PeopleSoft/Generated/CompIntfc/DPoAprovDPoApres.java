
//*****************************************************************
//* 
//* DPoAprovDPoApres.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:37:19 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DPoAprovDPoApres implements IDPoAprovDPoApres 
  {
  public DPoAprovDPoApres(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getSupervisorId() throws JOAException {
    return (String)m_oThis.getProperty("SUPERVISOR_ID");
 }

  public void setSupervisorId(String inSupervisorId) throws JOAException {
    m_oThis.setProperty("SUPERVISOR_ID", inSupervisorId);
 }

  public String getDRecbReject() throws JOAException {
    return (String)m_oThis.getProperty("D_RECB_REJECT");
 }

  public void setDRecbReject(String inDRecbReject) throws JOAException {
    m_oThis.setProperty("D_RECB_REJECT", inDRecbReject);
 }

  public String getDRecbApproval() throws JOAException {
    return (String)m_oThis.getProperty("D_RECB_APPROVAL");
 }

  public void setDRecbApproval(String inDRecbApproval) throws JOAException {
    m_oThis.setProperty("D_RECB_APPROVAL", inDRecbApproval);
 }

  public String getDAprovedFlg() throws JOAException {
    return (String)m_oThis.getProperty("D_APROVED_FLG");
 }

  public void setDAprovedFlg(String inDAprovedFlg) throws JOAException {
    m_oThis.setProperty("D_APROVED_FLG", inDAprovedFlg);
 }

  public String getCntrctId() throws JOAException {
    return (String)m_oThis.getProperty("CNTRCT_ID");
 }

  public void setCntrctId(String inCntrctId) throws JOAException {
    m_oThis.setProperty("CNTRCT_ID", inCntrctId);
 }

  public String getCntrctExpireDt() throws JOAException {
    return (String)m_oThis.getProperty("CNTRCT_EXPIRE_DT");
 }

  public void setCntrctExpireDt(String inCntrctExpireDt) throws JOAException {
    m_oThis.setProperty("CNTRCT_EXPIRE_DT", inCntrctExpireDt);
 }

  public String getDescr1002() throws JOAException {
    return (String)m_oThis.getProperty("DESCR100_2");
 }

  public void setDescr1002(String inDescr1002) throws JOAException {
    m_oThis.setProperty("DESCR100_2", inDescr1002);
 }

  public BigDecimal getGrossAmt() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("GROSS_AMT")));
 }

  public void setGrossAmt(BigDecimal inGrossAmt) throws JOAException {
    m_oThis.setProperty("GROSS_AMT", inGrossAmt.toString());
 }

  public String getVendorName1() throws JOAException {
    return (String)m_oThis.getProperty("VENDOR_NAME1");
 }

  public void setVendorName1(String inVendorName1) throws JOAException {
    m_oThis.setProperty("VENDOR_NAME1", inVendorName1);
 }

  public String getSendContactId() throws JOAException {
    return (String)m_oThis.getProperty("SEND_CONTACT_ID");
 }

  public void setSendContactId(String inSendContactId) throws JOAException {
    m_oThis.setProperty("SEND_CONTACT_ID", inSendContactId);
 }

  public String getForwardSw() throws JOAException {
    return (String)m_oThis.getProperty("FORWARD_SW");
 }

  public void setForwardSw(String inForwardSw) throws JOAException {
    m_oThis.setProperty("FORWARD_SW", inForwardSw);
 }

  public String getCntrctExpiryFlg() throws JOAException {
    return (String)m_oThis.getProperty("CNTRCT_EXPIRY_FLG");
 }

  public void setCntrctExpiryFlg(String inCntrctExpiryFlg) throws JOAException {
    m_oThis.setProperty("CNTRCT_EXPIRY_FLG", inCntrctExpiryFlg);
 }

  public String getCancel() throws JOAException {
    return (String)m_oThis.getProperty("CANCEL");
 }

  public void setCancel(String inCancel) throws JOAException {
    m_oThis.setProperty("CANCEL", inCancel);
 }

  public String getEmplid() throws JOAException {
    return (String)m_oThis.getProperty("EMPLID");
 }

  public void setEmplid(String inEmplid) throws JOAException {
    m_oThis.setProperty("EMPLID", inEmplid);
 }

  public String getBusinessUnit() throws JOAException {
    return (String)m_oThis.getProperty("BUSINESS_UNIT");
 }

  public void setBusinessUnit(String inBusinessUnit) throws JOAException {
    m_oThis.setProperty("BUSINESS_UNIT", inBusinessUnit);
 }

  public String getNfBrlId() throws JOAException {
    return (String)m_oThis.getProperty("NF_BRL_ID");
 }

  public void setNfBrlId(String inNfBrlId) throws JOAException {
    m_oThis.setProperty("NF_BRL_ID", inNfBrlId);
 }

  public String getDDescr500() throws JOAException {
    return (String)m_oThis.getProperty("D_DESCR500");
 }

  public void setDDescr500(String inDDescr500) throws JOAException {
    m_oThis.setProperty("D_DESCR500", inDDescr500);
 }

  public IDPoAprovDPoApresDPoAprdetVwCollection getDPoAprdetVw() throws JOAException {
    return (IDPoAprovDPoApresDPoAprdetVwCollection)m_oThis.getProperty("D_PO_APRDET_VW");
 }

  public IDPoAprovDPoApresBrlDistribLnCollection getBrlDistribLn() throws JOAException {
    return (IDPoAprovDPoApresBrlDistribLnCollection)m_oThis.getProperty("BRL_DISTRIB_LN");
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
