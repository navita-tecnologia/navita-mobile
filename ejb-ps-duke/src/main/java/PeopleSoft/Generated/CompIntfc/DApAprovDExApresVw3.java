
//*****************************************************************
//* 
//* DApAprovDExApresVw3.java (generated)
//* 
//* Automatically generated at Thu Feb 25 11:13:30 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DApAprovDExApresVw3 implements IDApAprovDExApresVw3 
  {
  public DApAprovDExApresVw3(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getSupervisorId() throws JOAException {
    return (String)m_oThis.getProperty("SUPERVISOR_ID");
 }

  public void setSupervisorId(String inSupervisorId) throws JOAException {
    m_oThis.setProperty("SUPERVISOR_ID", inSupervisorId);
 }

  public String getName() throws JOAException {
    return (String)m_oThis.getProperty("NAME");
 }

  public void setName(String inName) throws JOAException {
    m_oThis.setProperty("NAME", inName);
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
