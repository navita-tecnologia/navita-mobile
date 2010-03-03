
//*****************************************************************
//* 
//* DPoAprovDGridCntrct.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:37:19 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DPoAprovDGridCntrct implements IDPoAprovDGridCntrct 
  {
  public DPoAprovDGridCntrct(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getCntrctId0() throws JOAException {
    return (String)m_oThis.getProperty("CNTRCT_ID_0");
 }

  public void setCntrctId0(String inCntrctId0) throws JOAException {
    m_oThis.setProperty("CNTRCT_ID_0", inCntrctId0);
 }

  public String getCntrctExpireDt0() throws JOAException {
    return (String)m_oThis.getProperty("CNTRCT_EXPIRE_DT_0");
 }

  public void setCntrctExpireDt0(String inCntrctExpireDt0) throws JOAException {
    m_oThis.setProperty("CNTRCT_EXPIRE_DT_0", inCntrctExpireDt0);
 }

  public String getDRespons() throws JOAException {
    return (String)m_oThis.getProperty("D_RESPONS");
 }

  public void setDRespons(String inDRespons) throws JOAException {
    m_oThis.setProperty("D_RESPONS", inDRespons);
 }

  public String getDGestor() throws JOAException {
    return (String)m_oThis.getProperty("D_GESTOR");
 }

  public void setDGestor(String inDGestor) throws JOAException {
    m_oThis.setProperty("D_GESTOR", inDGestor);
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
