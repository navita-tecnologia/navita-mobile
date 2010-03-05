
//*****************************************************************
//* 
//* DAsmAprovDAsmVendorVw.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:18:37 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDAsmAprovDAsmVendorVw 
  {
  public long getItemNum() throws JOAException;
  public String getDNumAsm1() throws JOAException;
  public void setDNumAsm1(String inDNumAsm1) throws JOAException;
  public String getCreationDt1() throws JOAException;
  public void setCreationDt1(String inCreationDt1) throws JOAException;
  public BigDecimal getDAsmAmtTtl1() throws JOAException;
  public void setDAsmAmtTtl1(BigDecimal inDAsmAmtTtl1) throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
