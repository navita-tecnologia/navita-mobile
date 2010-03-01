
//*****************************************************************
//* 
//* DApAprov.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:36:10 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import psft.pt8.joa.IObject;
import psft.pt8.joa.JOAException;



public class DApAprov implements IDApAprov 
  {
  public DApAprov(IObject oThis) { m_oThis = oThis; }

  public String getDEmlBu() throws JOAException {
    return (String)m_oThis.getProperty("D_EML_BU");
 }

  public void setDEmlBu(String inDEmlBu) throws JOAException {
    m_oThis.setProperty("D_EML_BU", inDEmlBu);
 }

  public String getDEmlVoucherId() throws JOAException {
    return (String)m_oThis.getProperty("D_EML_VOUCHER_ID");
 }

  public void setDEmlVoucherId(String inDEmlVoucherId) throws JOAException {
    m_oThis.setProperty("D_EML_VOUCHER_ID", inDEmlVoucherId);
 }

  public String getDEmlEmplid() throws JOAException {
    return (String)m_oThis.getProperty("D_EML_EMPLID");
 }

  public void setDEmlEmplid(String inDEmlEmplid) throws JOAException {
    m_oThis.setProperty("D_EML_EMPLID", inDEmlEmplid);
 }

  public String getDEmlOprid() throws JOAException {
    return (String)m_oThis.getProperty("D_EML_OPRID");
 }

  public void setDEmlOprid(String inDEmlOprid) throws JOAException {
    m_oThis.setProperty("D_EML_OPRID", inDEmlOprid);
 }

  public IDApAprovDExApresVw3Collection getDExApresVw3() throws JOAException {
    return (IDApAprovDExApresVw3Collection)m_oThis.getProperty("D_EX_APRES_VW3");
 }

  public IDApAprovDApApresCollection getDApApres() throws JOAException {
    return (IDApAprovDApApresCollection)m_oThis.getProperty("D_AP_APRES");
 }

  public boolean getInteractiveMode() throws JOAException {
    return ((Boolean)m_oThis.getProperty("InteractiveMode")).booleanValue();
 }

  public void setInteractiveMode(boolean inInteractiveMode) throws JOAException {
    m_oThis.setProperty("InteractiveMode", new Boolean(inInteractiveMode));
 }

  public boolean getGetHistoryItems() throws JOAException {
    return ((Boolean)m_oThis.getProperty("GetHistoryItems")).booleanValue();
 }

  public void setGetHistoryItems(boolean inGetHistoryItems) throws JOAException {
    m_oThis.setProperty("GetHistoryItems", new Boolean(inGetHistoryItems));
 }

  public boolean getEditHistoryItems() throws JOAException {
    return ((Boolean)m_oThis.getProperty("EditHistoryItems")).booleanValue();
 }

  public void setEditHistoryItems(boolean inEditHistoryItems) throws JOAException {
    m_oThis.setProperty("EditHistoryItems", new Boolean(inEditHistoryItems));
 }

  public String getComponentName() throws JOAException {
    return (String)m_oThis.getProperty("ComponentName");
 }

  public String getCompIntfcName() throws JOAException {
    return (String)m_oThis.getProperty("CompIntfcName");
 }

  public String getMarket() throws JOAException {
    return (String)m_oThis.getProperty("Market");
 }

  public String getDescription() throws JOAException {
    return (String)m_oThis.getProperty("Description");
 }

  public boolean getGetDummyRows() throws JOAException {
    return ((Boolean)m_oThis.getProperty("GetDummyRows")).booleanValue();
 }

  public void setGetDummyRows(boolean inGetDummyRows) throws JOAException {
    m_oThis.setProperty("GetDummyRows", new Boolean(inGetDummyRows));
 }

  public boolean getStopOnFirstError() throws JOAException {
    return ((Boolean)m_oThis.getProperty("StopOnFirstError")).booleanValue();
 }

  public void setStopOnFirstError(boolean inStopOnFirstError) throws JOAException {
    m_oThis.setProperty("StopOnFirstError", new Boolean(inStopOnFirstError));
 }

  public ICompIntfcPropertyInfoCollection getPropertyInfoCollection() throws JOAException {
    return (ICompIntfcPropertyInfoCollection)m_oThis.getProperty("PropertyInfoCollection");
 }

  public ICompIntfcPropertyInfoCollection getCreateKeyInfoCollection() throws JOAException {
    return (ICompIntfcPropertyInfoCollection)m_oThis.getProperty("CreateKeyInfoCollection");
 }

  public ICompIntfcPropertyInfoCollection getGetKeyInfoCollection() throws JOAException {
    return (ICompIntfcPropertyInfoCollection)m_oThis.getProperty("GetKeyInfoCollection");
 }

  public ICompIntfcPropertyInfoCollection getFindKeyInfoCollection() throws JOAException {
    return (ICompIntfcPropertyInfoCollection)m_oThis.getProperty("FindKeyInfoCollection");
 }

  public boolean get() throws JOAException {
    Object[] args = new Object[0];
    return ((Boolean)(m_oThis.invokeMethod("Get", args))).booleanValue();
    }

  public boolean save() throws JOAException {
    Object[] args = new Object[0];
    return ((Boolean)(m_oThis.invokeMethod("Save", args))).booleanValue();
    }

  public boolean cancel() throws JOAException {
    Object[] args = new Object[0];
    return ((Boolean)(m_oThis.invokeMethod("Cancel", args))).booleanValue();
    }

  public IDApAprovCollection find() throws JOAException {
    Object[] args = new Object[0];
    return (IDApAprovCollection)m_oThis.invokeMethod("Find", args);
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
