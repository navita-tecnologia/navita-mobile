
//*****************************************************************
//* 
//* DExAdAprovExAdvLineCollection.java (generated)
//* 
//* Automatically generated at Wed Mar 03 14:27:00 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDExAdAprovExAdvLineCollection 
  {
  public long getCount() throws JOAException;
  public IDExAdAprovExAdvLine item(long Index) throws JOAException;
  public IDExAdAprovExAdvLine insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDExAdAprovExAdvLine itemByKeys() throws JOAException;
  public IDExAdAprovExAdvLine currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDExAdAprovExAdvLine getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
