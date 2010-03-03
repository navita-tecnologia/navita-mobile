
//*****************************************************************
//* 
//* DPoAprovDAprovrecb.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:11:38 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDPoAprovDAprovrecb 
  {
  public long getItemNum() throws JOAException;
  public String getDExDtEncam() throws JOAException;
  public void setDExDtEncam(String inDExDtEncam) throws JOAException;
  public String getOprid() throws JOAException;
  public void setOprid(String inOprid) throws JOAException;
  public String getDescr1002() throws JOAException;
  public void setDescr1002(String inDescr1002) throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
