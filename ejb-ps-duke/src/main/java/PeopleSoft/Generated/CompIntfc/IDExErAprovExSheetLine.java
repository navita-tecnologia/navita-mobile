
//*****************************************************************
//* 
//* DExErAprovExSheetLine.java (generated)
//* 
//* Automatically generated at Wed Mar 03 14:27:00 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDExErAprovExSheetLine 
  {
  public long getItemNum() throws JOAException;
  public String getActivityId() throws JOAException;
  public void setActivityId(String inActivityId) throws JOAException;
  public String getApproveFlag() throws JOAException;
  public void setApproveFlag(String inApproveFlag) throws JOAException;
  public String getBusinessUnitPc() throws JOAException;
  public void setBusinessUnitPc(String inBusinessUnitPc) throws JOAException;
  public String getProjectId() throws JOAException;
  public void setProjectId(String inProjectId) throws JOAException;
  public String getExpenseType() throws JOAException;
  public void setExpenseType(String inExpenseType) throws JOAException;
  public String getTransDt() throws JOAException;
  public void setTransDt(String inTransDt) throws JOAException;
  public BigDecimal getMonetaryAmount() throws JOAException;
  public void setMonetaryAmount(BigDecimal inMonetaryAmount) throws JOAException;
  public String getCurrencyCd() throws JOAException;
  public void setCurrencyCd(String inCurrencyCd) throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
