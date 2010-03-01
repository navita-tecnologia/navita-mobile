
//*****************************************************************
//* 
//* DApAprovDApApresDPymntXrefVw.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:36:10 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DApAprovDApApresDPymntXrefVw implements IDApAprovDApApresDPymntXrefVw 
  {
  public DApAprovDApApresDPymntXrefVw(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getScheduledPayDt() throws JOAException {
    return (String)m_oThis.getProperty("SCHEDULED_PAY_DT");
 }

  public void setScheduledPayDt(String inScheduledPayDt) throws JOAException {
    m_oThis.setProperty("SCHEDULED_PAY_DT", inScheduledPayDt);
 }

  public BigDecimal getMonetaryAmount2() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("MONETARY_AMOUNT_2")));
 }

  public void setMonetaryAmount2(BigDecimal inMonetaryAmount2) throws JOAException {
    m_oThis.setProperty("MONETARY_AMOUNT_2", inMonetaryAmount2.toString());
 }

  public String getVendorName1() throws JOAException {
    return (String)m_oThis.getProperty("VENDOR_NAME1");
 }

  public void setVendorName1(String inVendorName1) throws JOAException {
    m_oThis.setProperty("VENDOR_NAME1", inVendorName1);
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
