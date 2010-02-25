
//*****************************************************************
//* 
//* DApAprovDApApresDVchrLnVw.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:36:10 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDApAprovDApApresDVchrLnVw 
  {
  public long getItemNum() throws JOAException;
  public String getInvItemId() throws JOAException;
  public void setInvItemId(String inInvItemId) throws JOAException;
  public String getDescr() throws JOAException;
  public void setDescr(String inDescr) throws JOAException;
  public String getDescr254Mixed() throws JOAException;
  public void setDescr254Mixed(String inDescr254Mixed) throws JOAException;
  public IDApAprovDApApresDVchrLnVwDDistrLnVwCollection getDDistrLnVw() throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
