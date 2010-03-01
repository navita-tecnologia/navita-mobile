
//*****************************************************************
//* 
//* CompIntfcPropertyInfoCollection.java (generated)
//* 
//* Automatically generated at Mon Jul 10 18:07:33 2006
//* 
//* Copyright (c) 2000-2005 PeopleSoft, Inc.  All Rights Reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import psft.pt8.joa.JOAException;

public interface ICompIntfcPropertyInfoCollection 
  {
  public long getCount() throws JOAException;
  public ICompIntfcPropertyInfo item(long Index) throws JOAException;
  public ICompIntfcPropertyInfo itemByName(String Name) throws JOAException;
  }
