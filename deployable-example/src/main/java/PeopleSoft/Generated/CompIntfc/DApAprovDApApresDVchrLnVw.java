
//*****************************************************************
//* 
//* DApAprovDApApresDVchrLnVw.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:36:10 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DApAprovDApApresDVchrLnVw implements IDApAprovDApApresDVchrLnVw 
  {
  public DApAprovDApApresDVchrLnVw(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getInvItemId() throws JOAException {
    return (String)m_oThis.getProperty("INV_ITEM_ID");
 }

  public void setInvItemId(String inInvItemId) throws JOAException {
    m_oThis.setProperty("INV_ITEM_ID", inInvItemId);
 }

  public String getDescr() throws JOAException {
    return (String)m_oThis.getProperty("DESCR");
 }

  public void setDescr(String inDescr) throws JOAException {
    m_oThis.setProperty("DESCR", inDescr);
 }

  public String getDescr254Mixed() throws JOAException {
    return (String)m_oThis.getProperty("DESCR254_MIXED");
 }

  public void setDescr254Mixed(String inDescr254Mixed) throws JOAException {
    m_oThis.setProperty("DESCR254_MIXED", inDescr254Mixed);
 }

  public IDApAprovDApApresDVchrLnVwDDistrLnVwCollection getDDistrLnVw() throws JOAException {
    return (IDApAprovDApApresDVchrLnVwDDistrLnVwCollection)m_oThis.getProperty("D_DISTR_LN_VW");
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
