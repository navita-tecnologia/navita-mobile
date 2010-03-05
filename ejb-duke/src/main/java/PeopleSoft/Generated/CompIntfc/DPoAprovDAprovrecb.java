
//*****************************************************************
//* 
//* DPoAprovDAprovrecb.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:11:38 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DPoAprovDAprovrecb implements IDPoAprovDAprovrecb 
  {
  public DPoAprovDAprovrecb(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getDExDtEncam() throws JOAException {
    return (String)m_oThis.getProperty("D_EX_DT_ENCAM");
 }

  public void setDExDtEncam(String inDExDtEncam) throws JOAException {
    m_oThis.setProperty("D_EX_DT_ENCAM", inDExDtEncam);
 }

  public String getOprid() throws JOAException {
    return (String)m_oThis.getProperty("OPRID");
 }

  public void setOprid(String inOprid) throws JOAException {
    m_oThis.setProperty("OPRID", inOprid);
 }

  public String getDescr1002() throws JOAException {
    return (String)m_oThis.getProperty("DESCR100_2");
 }

  public void setDescr1002(String inDescr1002) throws JOAException {
    m_oThis.setProperty("DESCR100_2", inDescr1002);
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
