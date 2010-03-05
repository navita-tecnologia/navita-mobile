
//*****************************************************************
//* 
//* DPoAprovDPoApresBrlDistribLnCollection.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:11:38 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDPoAprovDPoApresBrlDistribLnCollection 
  {
  public long getCount() throws JOAException;
  public IDPoAprovDPoApresBrlDistribLn item(long Index) throws JOAException;
  public IDPoAprovDPoApresBrlDistribLn insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDPoAprovDPoApresBrlDistribLn itemByKeys(BigDecimal DistribLineNum) throws JOAException;
  public IDPoAprovDPoApresBrlDistribLn currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDPoAprovDPoApresBrlDistribLn getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
