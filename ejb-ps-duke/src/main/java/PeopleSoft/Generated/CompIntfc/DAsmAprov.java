
//*****************************************************************
//* 
//* DAsmAprov.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:18:37 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DAsmAprov implements IDAsmAprov 
  {
  public DAsmAprov(IObject oThis) { m_oThis = oThis; }

  public String getCreationDt() throws JOAException {
    return (String)m_oThis.getProperty("CREATION_DT");
 }

  public void setCreationDt(String inCreationDt) throws JOAException {
    m_oThis.setProperty("CREATION_DT", inCreationDt);
 }

  public String getDescr254() throws JOAException {
    return (String)m_oThis.getProperty("DESCR254");
 }

  public void setDescr254(String inDescr254) throws JOAException {
    m_oThis.setProperty("DESCR254", inDescr254);
 }

  public String getDescr254Mixed() throws JOAException {
    return (String)m_oThis.getProperty("DESCR254_MIXED");
 }

  public void setDescr254Mixed(String inDescr254Mixed) throws JOAException {
    m_oThis.setProperty("DESCR254_MIXED", inDescr254Mixed);
 }

  public String getDeadlineDt() throws JOAException {
    return (String)m_oThis.getProperty("DEADLINE_DT");
 }

  public void setDeadlineDt(String inDeadlineDt) throws JOAException {
    m_oThis.setProperty("DEADLINE_DT", inDeadlineDt);
 }

  public BigDecimal getDAsmAmtTtl() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("D_ASM_AMT_TTL")));
 }

  public void setDAsmAmtTtl(BigDecimal inDAsmAmtTtl) throws JOAException {
    m_oThis.setProperty("D_ASM_AMT_TTL", inDAsmAmtTtl.toString());
 }

  public String getComments() throws JOAException {
    return (String)m_oThis.getProperty("COMMENTS");
 }

  public void setComments(String inComments) throws JOAException {
    m_oThis.setProperty("COMMENTS", inComments);
 }

  public IDAsmAprovDExApresVw3Collection getDExApresVw3() throws JOAException {
    return (IDAsmAprovDExApresVw3Collection)m_oThis.getProperty("D_EX_APRES_VW3");
 }

  public IDAsmAprovDAsmApresCollection getDAsmApres() throws JOAException {
    return (IDAsmAprovDAsmApresCollection)m_oThis.getProperty("D_ASM_APRES");
 }

  public IDAsmAprovDAsmCntrctVwCollection getDAsmCntrctVw() throws JOAException {
    return (IDAsmAprovDAsmCntrctVwCollection)m_oThis.getProperty("D_ASM_CNTRCT_VW");
 }

  public IDAsmAprovDAsmVendorVwCollection getDAsmVendorVw() throws JOAException {
    return (IDAsmAprovDAsmVendorVwCollection)m_oThis.getProperty("D_ASM_VENDOR_VW");
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

  public IDAsmAprovCollection find() throws JOAException {
    Object[] args = new Object[0];
    return (IDAsmAprovCollection)m_oThis.invokeMethod("Find", args);
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
