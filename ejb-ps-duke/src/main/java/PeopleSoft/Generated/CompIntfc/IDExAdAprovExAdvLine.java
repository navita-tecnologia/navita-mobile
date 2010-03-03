
//*****************************************************************
//* 
//* DExAdAprovExAdvLine.java (generated)
//* 
//* Automatically generated at Wed Mar 03 14:27:00 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDExAdAprovExAdvLine 
  {
  public long getItemNum() throws JOAException;
  public String getAdvanceSource() throws JOAException;
  public void setAdvanceSource(String inAdvanceSource) throws JOAException;
  public BigDecimal getMonetaryAmount() throws JOAException;
  public void setMonetaryAmount(BigDecimal inMonetaryAmount) throws JOAException;
  public String getCurrencyCd() throws JOAException;
  public void setCurrencyCd(String inCurrencyCd) throws JOAException;
  public String getDescr() throws JOAException;
  public void setDescr(String inDescr) throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
