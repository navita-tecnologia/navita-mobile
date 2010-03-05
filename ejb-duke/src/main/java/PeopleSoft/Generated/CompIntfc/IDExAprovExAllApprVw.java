
//*****************************************************************
//* 
//* DExAprovExAllApprVw.java (generated)
//* 
//* Automatically generated at Wed Mar 03 14:27:00 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDExAprovExAllApprVw 
  {
  public long getItemNum() throws JOAException;
  public String getApprTransType() throws JOAException;
  public void setApprTransType(String inApprTransType) throws JOAException;
  public String getTransactionId() throws JOAException;
  public void setTransactionId(String inTransactionId) throws JOAException;
  public String getLineSelectCb() throws JOAException;
  public void setLineSelectCb(String inLineSelectCb) throws JOAException;
  public String getDescr() throws JOAException;
  public void setDescr(String inDescr) throws JOAException;
  public String getEmplid() throws JOAException;
  public void setEmplid(String inEmplid) throws JOAException;
  public String getName() throws JOAException;
  public void setName(String inName) throws JOAException;
  public String getSubmissionDate() throws JOAException;
  public void setSubmissionDate(String inSubmissionDate) throws JOAException;
  public BigDecimal getTotalAmt() throws JOAException;
  public void setTotalAmt(BigDecimal inTotalAmt) throws JOAException;
  public String getCurrencyCd() throws JOAException;
  public void setCurrencyCd(String inCurrencyCd) throws JOAException;
  public String getApprvrDescr() throws JOAException;
  public void setApprvrDescr(String inApprvrDescr) throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
