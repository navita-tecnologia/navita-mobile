
//*****************************************************************
//* 
//* DExAdAprovExAdvLine.java (generated)
//* 
//* Automatically generated at Wed Mar 03 14:27:00 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DExAdAprovExAdvLine implements IDExAdAprovExAdvLine 
  {
  public DExAdAprovExAdvLine(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getAdvanceSource() throws JOAException {
    return (String)m_oThis.getProperty("ADVANCE_SOURCE");
 }

  public void setAdvanceSource(String inAdvanceSource) throws JOAException {
    m_oThis.setProperty("ADVANCE_SOURCE", inAdvanceSource);
 }

  public BigDecimal getMonetaryAmount() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("MONETARY_AMOUNT")));
 }

  public void setMonetaryAmount(BigDecimal inMonetaryAmount) throws JOAException {
    m_oThis.setProperty("MONETARY_AMOUNT", inMonetaryAmount.toString());
 }

  public String getCurrencyCd() throws JOAException {
    return (String)m_oThis.getProperty("CURRENCY_CD");
 }

  public void setCurrencyCd(String inCurrencyCd) throws JOAException {
    m_oThis.setProperty("CURRENCY_CD", inCurrencyCd);
 }

  public String getDescr() throws JOAException {
    return (String)m_oThis.getProperty("DESCR");
 }

  public void setDescr(String inDescr) throws JOAException {
    m_oThis.setProperty("DESCR", inDescr);
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
