
//*****************************************************************
//* 
//* DAsmAprovDAsmCntrctVw.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:18:37 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DAsmAprovDAsmCntrctVw implements IDAsmAprovDAsmCntrctVw 
  {
  public DAsmAprovDAsmCntrctVw(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getCntrctId3() throws JOAException {
    return (String)m_oThis.getProperty("CNTRCT_ID_3");
 }

  public void setCntrctId3(String inCntrctId3) throws JOAException {
    m_oThis.setProperty("CNTRCT_ID_3", inCntrctId3);
 }

  public String getCntrctExpireDt3() throws JOAException {
    return (String)m_oThis.getProperty("CNTRCT_EXPIRE_DT_3");
 }

  public void setCntrctExpireDt3(String inCntrctExpireDt3) throws JOAException {
    m_oThis.setProperty("CNTRCT_EXPIRE_DT_3", inCntrctExpireDt3);
 }

  public String getDRespons1() throws JOAException {
    return (String)m_oThis.getProperty("D_RESPONS_1");
 }

  public void setDRespons1(String inDRespons1) throws JOAException {
    m_oThis.setProperty("D_RESPONS_1", inDRespons1);
 }

  public String getDGestor1() throws JOAException {
    return (String)m_oThis.getProperty("D_GESTOR_1");
 }

  public void setDGestor1(String inDGestor1) throws JOAException {
    m_oThis.setProperty("D_GESTOR_1", inDGestor1);
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
