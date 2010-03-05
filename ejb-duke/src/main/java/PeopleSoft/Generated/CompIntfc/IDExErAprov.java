
//*****************************************************************
//* 
//* DExErAprov.java (generated)
//* 
//* Automatically generated at Wed Mar 03 14:27:00 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDExErAprov 
  {
  public String getTransactionId() throws JOAException;
  public void setTransactionId(String inTransactionId) throws JOAException;
  public String getPersonName() throws JOAException;
  public void setPersonName(String inPersonName) throws JOAException;
  public String getPbApprove() throws JOAException;
  public void setPbApprove(String inPbApprove) throws JOAException;
  public String getReturnToEe() throws JOAException;
  public void setReturnToEe(String inReturnToEe) throws JOAException;
  public String getPurposeTypeCd() throws JOAException;
  public void setPurposeTypeCd(String inPurposeTypeCd) throws JOAException;
  public String getDescrLocation() throws JOAException;
  public void setDescrLocation(String inDescrLocation) throws JOAException;
  public String getComments0() throws JOAException;
  public void setComments0(String inComments0) throws JOAException;
  public String getReferenceId() throws JOAException;
  public void setReferenceId(String inReferenceId) throws JOAException;
  public String getSheetName() throws JOAException;
  public void setSheetName(String inSheetName) throws JOAException;
  public String getAccountingDt() throws JOAException;
  public void setAccountingDt(String inAccountingDt) throws JOAException;
  public String getComments() throws JOAException;
  public void setComments(String inComments) throws JOAException;
  public String getSupervisorId() throws JOAException;
  public void setSupervisorId(String inSupervisorId) throws JOAException;
  public String getDExEncamSup() throws JOAException;
  public void setDExEncamSup(String inDExEncamSup) throws JOAException;
  public String getButton() throws JOAException;
  public void setButton(String inButton) throws JOAException;
  public String getForwardSw() throws JOAException;
  public void setForwardSw(String inForwardSw) throws JOAException;
  public IDExErAprovExSheetLineCollection getExSheetLine() throws JOAException;
  public String getSheetId() throws JOAException;
  public void setSheetId(String inSheetId) throws JOAException;
  public String getEmplid() throws JOAException;
  public void setEmplid(String inEmplid) throws JOAException;
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
  public IDExErAprovCollection find() throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
