
//*****************************************************************
//* 
//* DAsmAprovDAsmApres.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:36:10 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DAsmAprovDAsmApres implements IDAsmAprovDAsmApres 
  {
  public DAsmAprovDAsmApres(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getSupervisorId() throws JOAException {
    return (String)m_oThis.getProperty("SUPERVISOR_ID");
 }

  public void setSupervisorId(String inSupervisorId) throws JOAException {
    m_oThis.setProperty("SUPERVISOR_ID", inSupervisorId);
 }

  public String getSel() throws JOAException {
    return (String)m_oThis.getProperty("SEL");
 }

  public void setSel(String inSel) throws JOAException {
    m_oThis.setProperty("SEL", inSel);
 }

  public String getApprovePb() throws JOAException {
    return (String)m_oThis.getProperty("APPROVE_PB");
 }

  public void setApprovePb(String inApprovePb) throws JOAException {
    m_oThis.setProperty("APPROVE_PB", inApprovePb);
 }

  public String getDenyPb() throws JOAException {
    return (String)m_oThis.getProperty("DENY_PB");
 }

  public void setDenyPb(String inDenyPb) throws JOAException {
    m_oThis.setProperty("DENY_PB", inDenyPb);
 }

  public BigDecimal getDAsmAmtTtl() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("D_ASM_AMT_TTL")));
 }

  public void setDAsmAmtTtl(BigDecimal inDAsmAmtTtl) throws JOAException {
    m_oThis.setProperty("D_ASM_AMT_TTL", inDAsmAmtTtl.toString());
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

  public String getEmplid() throws JOAException {
    return (String)m_oThis.getProperty("EMPLID");
 }

  public void setEmplid(String inEmplid) throws JOAException {
    m_oThis.setProperty("EMPLID", inEmplid);
 }

  public String getBusinessUnit1() throws JOAException {
    return (String)m_oThis.getProperty("BUSINESS_UNIT_1");
 }

  public void setBusinessUnit1(String inBusinessUnit1) throws JOAException {
    m_oThis.setProperty("BUSINESS_UNIT_1", inBusinessUnit1);
 }

  public String getDNumAsm() throws JOAException {
    return (String)m_oThis.getProperty("D_NUM_ASM");
 }

  public void setDNumAsm(String inDNumAsm) throws JOAException {
    m_oThis.setProperty("D_NUM_ASM", inDNumAsm);
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
