
//*****************************************************************
//* 
//* DAsmAprovDAsmCntrctVw.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:18:37 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDAsmAprovDAsmCntrctVw 
  {
  public long getItemNum() throws JOAException;
  public String getCntrctId3() throws JOAException;
  public void setCntrctId3(String inCntrctId3) throws JOAException;
  public String getCntrctExpireDt3() throws JOAException;
  public void setCntrctExpireDt3(String inCntrctExpireDt3) throws JOAException;
  public String getDRespons1() throws JOAException;
  public void setDRespons1(String inDRespons1) throws JOAException;
  public String getDGestor1() throws JOAException;
  public void setDGestor1(String inDGestor1) throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
