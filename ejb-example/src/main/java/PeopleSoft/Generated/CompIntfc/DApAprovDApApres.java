
//*****************************************************************
//* 
//* DApAprovDApApres.java (generated)
//* 
//* Automatically generated at Thu Feb 25 11:13:30 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DApAprovDApApres implements IDApAprovDApApres 
  {
  public DApAprovDApApres(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getSupervisorId() throws JOAException {
    return (String)m_oThis.getProperty("SUPERVISOR_ID");
 }

  public void setSupervisorId(String inSupervisorId) throws JOAException {
    m_oThis.setProperty("SUPERVISOR_ID", inSupervisorId);
 }

  public String getMessageText() throws JOAException {
    return (String)m_oThis.getProperty("MESSAGE_TEXT");
 }

  public void setMessageText(String inMessageText) throws JOAException {
    m_oThis.setProperty("MESSAGE_TEXT", inMessageText);
 }

  public String getDVchrReject() throws JOAException {
    return (String)m_oThis.getProperty("D_VCHR_REJECT");
 }

  public void setDVchrReject(String inDVchrReject) throws JOAException {
    m_oThis.setProperty("D_VCHR_REJECT", inDVchrReject);
 }

  public String getDVchrApproval() throws JOAException {
    return (String)m_oThis.getProperty("D_VCHR_APPROVAL");
 }

  public void setDVchrApproval(String inDVchrApproval) throws JOAException {
    m_oThis.setProperty("D_VCHR_APPROVAL", inDVchrApproval);
 }

  public String getDAprovedFlg() throws JOAException {
    return (String)m_oThis.getProperty("D_APROVED_FLG");
 }

  public void setDAprovedFlg(String inDAprovedFlg) throws JOAException {
    m_oThis.setProperty("D_APROVED_FLG", inDAprovedFlg);
 }

  public BigDecimal getGrossAmt() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("GROSS_AMT")));
 }

  public void setGrossAmt(BigDecimal inGrossAmt) throws JOAException {
    m_oThis.setProperty("GROSS_AMT", inGrossAmt.toString());
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

  public String getBusinessUnit() throws JOAException {
    return (String)m_oThis.getProperty("BUSINESS_UNIT");
 }

  public void setBusinessUnit(String inBusinessUnit) throws JOAException {
    m_oThis.setProperty("BUSINESS_UNIT", inBusinessUnit);
 }

  public String getVoucherId() throws JOAException {
    return (String)m_oThis.getProperty("VOUCHER_ID");
 }

  public void setVoucherId(String inVoucherId) throws JOAException {
    m_oThis.setProperty("VOUCHER_ID", inVoucherId);
 }

  public String getEdittable40() throws JOAException {
    return (String)m_oThis.getProperty("EDITTABLE40");
 }

  public void setEdittable40(String inEdittable40) throws JOAException {
    m_oThis.setProperty("EDITTABLE40", inEdittable40);
 }

  public IDApAprovDApApresDPymntXrefVwCollection getDPymntXrefVw() throws JOAException {
    return (IDApAprovDApApresDPymntXrefVwCollection)m_oThis.getProperty("D_PYMNT_XREF_VW");
 }

  public IDApAprovDApApresDVchrLnVwCollection getDVchrLnVw() throws JOAException {
    return (IDApAprovDApApresDVchrLnVwCollection)m_oThis.getProperty("D_VCHR_LN_VW");
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
