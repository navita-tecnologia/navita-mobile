
//*****************************************************************
//* 
//* DPoAprovDExApresVw3.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:37:19 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDPoAprovDExApresVw3 
  {
  public long getItemNum() throws JOAException;
  public String getSupervisorId() throws JOAException;
  public void setSupervisorId(String inSupervisorId) throws JOAException;
  public String getName() throws JOAException;
  public void setName(String inName) throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
