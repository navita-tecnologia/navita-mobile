
//*****************************************************************
//* 
//* DExAprov.java (generated)
//* 
//* Automatically generated at Wed Mar 03 14:27:00 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDExAprov 
  {
  public IDExAprovExAllApprVwCollection getExAllApprVw() throws JOAException;
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
  public IDExAprovCollection find() throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
