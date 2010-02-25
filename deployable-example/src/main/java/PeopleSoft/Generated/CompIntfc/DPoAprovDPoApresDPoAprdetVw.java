
//*****************************************************************
//* 
//* DPoAprovDPoApresDPoAprdetVw.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:37:19 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DPoAprovDPoApresDPoAprdetVw implements IDPoAprovDPoApresDPoAprdetVw 
  {
  public DPoAprovDPoApresDPoAprdetVw(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getDescr254Mixed() throws JOAException {
    return (String)m_oThis.getProperty("DESCR254_MIXED");
 }

  public void setDescr254Mixed(String inDescr254Mixed) throws JOAException {
    m_oThis.setProperty("DESCR254_MIXED", inDescr254Mixed);
 }

  public String getDescr2541() throws JOAException {
    return (String)m_oThis.getProperty("DESCR254_1");
 }

  public void setDescr2541(String inDescr2541) throws JOAException {
    m_oThis.setProperty("DESCR254_1", inDescr2541);
 }

  public String getDescr254() throws JOAException {
    return (String)m_oThis.getProperty("DESCR254");
 }

  public void setDescr254(String inDescr254) throws JOAException {
    m_oThis.setProperty("DESCR254", inDescr254);
 }

  public String getDueDt() throws JOAException {
    return (String)m_oThis.getProperty("DUE_DT");
 }

  public void setDueDt(String inDueDt) throws JOAException {
    m_oThis.setProperty("DUE_DT", inDueDt);
 }

  public String getShipmentNo() throws JOAException {
    return (String)m_oThis.getProperty("SHIPMENT_NO");
 }

  public void setShipmentNo(String inShipmentNo) throws JOAException {
    m_oThis.setProperty("SHIPMENT_NO", inShipmentNo);
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
