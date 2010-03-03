
//*****************************************************************
//* 
//* DAsmAprovDAsmVendorVw.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:18:37 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DAsmAprovDAsmVendorVw implements IDAsmAprovDAsmVendorVw 
  {
  public DAsmAprovDAsmVendorVw(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getDNumAsm1() throws JOAException {
    return (String)m_oThis.getProperty("D_NUM_ASM_1");
 }

  public void setDNumAsm1(String inDNumAsm1) throws JOAException {
    m_oThis.setProperty("D_NUM_ASM_1", inDNumAsm1);
 }

  public String getCreationDt1() throws JOAException {
    return (String)m_oThis.getProperty("CREATION_DT_1");
 }

  public void setCreationDt1(String inCreationDt1) throws JOAException {
    m_oThis.setProperty("CREATION_DT_1", inCreationDt1);
 }

  public BigDecimal getDAsmAmtTtl1() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("D_ASM_AMT_TTL_1")));
 }

  public void setDAsmAmtTtl1(BigDecimal inDAsmAmtTtl1) throws JOAException {
    m_oThis.setProperty("D_ASM_AMT_TTL_1", inDAsmAmtTtl1.toString());
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
