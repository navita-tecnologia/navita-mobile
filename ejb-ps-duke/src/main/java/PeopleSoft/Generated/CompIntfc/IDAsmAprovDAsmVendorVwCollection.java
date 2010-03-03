
//*****************************************************************
//* 
//* DAsmAprovDAsmVendorVwCollection.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:18:37 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDAsmAprovDAsmVendorVwCollection 
  {
  public long getCount() throws JOAException;
  public IDAsmAprovDAsmVendorVw item(long Index) throws JOAException;
  public IDAsmAprovDAsmVendorVw insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDAsmAprovDAsmVendorVw itemByKeys(String DNumAsm1) throws JOAException;
  public IDAsmAprovDAsmVendorVw currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDAsmAprovDAsmVendorVw getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
