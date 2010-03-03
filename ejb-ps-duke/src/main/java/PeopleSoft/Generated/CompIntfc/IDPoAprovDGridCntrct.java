
//*****************************************************************
//* 
//* DPoAprovDGridCntrct.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:11:38 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDPoAprovDGridCntrct 
  {
  public long getItemNum() throws JOAException;
  public String getCntrctId0() throws JOAException;
  public void setCntrctId0(String inCntrctId0) throws JOAException;
  public String getCntrctExpireDt0() throws JOAException;
  public void setCntrctExpireDt0(String inCntrctExpireDt0) throws JOAException;
  public String getDRespons() throws JOAException;
  public void setDRespons(String inDRespons) throws JOAException;
  public String getDGestor() throws JOAException;
  public void setDGestor(String inDGestor) throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
