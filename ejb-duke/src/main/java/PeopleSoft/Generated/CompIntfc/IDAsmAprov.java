
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

public interface IDAsmAprov 
  {
  public String getCreationDt() throws JOAException;
  public void setCreationDt(String inCreationDt) throws JOAException;
  public String getDescr254() throws JOAException;
  public void setDescr254(String inDescr254) throws JOAException;
  public String getDescr254Mixed() throws JOAException;
  public void setDescr254Mixed(String inDescr254Mixed) throws JOAException;
  public String getDeadlineDt() throws JOAException;
  public void setDeadlineDt(String inDeadlineDt) throws JOAException;
  public BigDecimal getDAsmAmtTtl() throws JOAException;
  public void setDAsmAmtTtl(BigDecimal inDAsmAmtTtl) throws JOAException;
  public String getComments() throws JOAException;
  public void setComments(String inComments) throws JOAException;
  public IDAsmAprovDExApresVw3Collection getDExApresVw3() throws JOAException;
  public IDAsmAprovDAsmApresCollection getDAsmApres() throws JOAException;
  public IDAsmAprovDAsmCntrctVwCollection getDAsmCntrctVw() throws JOAException;
  public IDAsmAprovDAsmVendorVwCollection getDAsmVendorVw() throws JOAException;
  public boolean getInteractiveMode() throws JOAException;
  public void setInteractiveMode(boolean inInteractiveMode) throws JOAException;
  public boolean getGetHistoryItems() throws JOAException;
  public void setGetHistoryItems(boolean inGetHistoryItems) throws JOAException;
  public boolean getEditHistoryItems() throws JOAException;
  public void setEditHistoryItems(boolean inEditHistoryItems) throws JOAException;
  public String getComponentName() throws JOAException;
  public String getCompIntfcName() throws JOAException;
  public String getMarket() throws JOAException;
  public String getDescription() throws JOAException;
  public boolean getGetDummyRows() throws JOAException;
  public void setGetDummyRows(boolean inGetDummyRows) throws JOAException;
  public boolean getStopOnFirstError() throws JOAException;
  public void setStopOnFirstError(boolean inStopOnFirstError) throws JOAException;
  public ICompIntfcPropertyInfoCollection getPropertyInfoCollection() throws JOAException;
  public ICompIntfcPropertyInfoCollection getCreateKeyInfoCollection() throws JOAException;
  public ICompIntfcPropertyInfoCollection getGetKeyInfoCollection() throws JOAException;
  public ICompIntfcPropertyInfoCollection getFindKeyInfoCollection() throws JOAException;
  public boolean get() throws JOAException;
  public boolean save() throws JOAException;
  public boolean cancel() throws JOAException;
  public IDAsmAprovCollection find() throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
