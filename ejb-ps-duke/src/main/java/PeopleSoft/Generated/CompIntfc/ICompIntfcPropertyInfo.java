
//*****************************************************************
//* 
//* CompIntfcPropertyInfo.java (generated)
//* 
//* Automatically generated at Mon Jul 10 18:07:33 2006
//* 
//* Copyright (c) 2000-2005 PeopleSoft, Inc.  All Rights Reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import psft.pt8.joa.JOAException;

public interface ICompIntfcPropertyInfo 
  {
  public ICompIntfcPropertyInfoCollection getPropertyInfoCollection() throws JOAException;
  public String getName() throws JOAException;
  public String getRecordName() throws JOAException;
  public String getFieldName() throws JOAException;
  public String getLabelLong() throws JOAException;
  public String getLabelShort() throws JOAException;
  public boolean getIsCollection() throws JOAException;
  public long getType() throws JOAException;
  public long getOAType() throws JOAException;
  public long getFormat() throws JOAException;
  public boolean getKey() throws JOAException;
  public boolean getRequired() throws JOAException;
  public boolean getXlat() throws JOAException;
  public boolean getYesno() throws JOAException;
  public boolean getPrompt() throws JOAException;
  public long getLength() throws JOAException;
  public long getDecimalPosition() throws JOAException;
  public boolean getIsReadOnly() throws JOAException;
  public boolean getAltkey() throws JOAException;
  public boolean getListboxitem() throws JOAException;
  }
