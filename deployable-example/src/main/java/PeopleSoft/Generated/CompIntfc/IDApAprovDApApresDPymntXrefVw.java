
//*****************************************************************
//* 
//* DApAprovDApApresDPymntXrefVw.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:36:10 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDApAprovDApApresDPymntXrefVw 
  {
  public long getItemNum() throws JOAException;
  public String getScheduledPayDt() throws JOAException;
  public void setScheduledPayDt(String inScheduledPayDt) throws JOAException;
  public BigDecimal getMonetaryAmount2() throws JOAException;
  public void setMonetaryAmount2(BigDecimal inMonetaryAmount2) throws JOAException;
  public String getVendorName1() throws JOAException;
  public void setVendorName1(String inVendorName1) throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
