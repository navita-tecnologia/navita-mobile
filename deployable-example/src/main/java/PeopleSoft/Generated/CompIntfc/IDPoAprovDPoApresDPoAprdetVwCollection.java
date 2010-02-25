
//*****************************************************************
//* 
//* DPoAprovDPoApresDPoAprdetVwCollection.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:37:19 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDPoAprovDPoApresDPoAprdetVwCollection 
  {
  public long getCount() throws JOAException;
  public IDPoAprovDPoApresDPoAprdetVw item(long Index) throws JOAException;
  public IDPoAprovDPoApresDPoAprdetVw insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDPoAprovDPoApresDPoAprdetVw itemByKeys() throws JOAException;
  public IDPoAprovDPoApresDPoAprdetVw currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDPoAprovDPoApresDPoAprdetVw getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
