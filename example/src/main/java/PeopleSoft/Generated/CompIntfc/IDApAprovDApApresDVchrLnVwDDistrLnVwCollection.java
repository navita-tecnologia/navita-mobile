
//*****************************************************************
//* 
//* DApAprovDApApresDVchrLnVwDDistrLnVwCollection.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:36:10 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDApAprovDApApresDVchrLnVwDDistrLnVwCollection 
  {
  public long getCount() throws JOAException;
  public IDApAprovDApApresDVchrLnVwDDistrLnVw item(long Index) throws JOAException;
  public IDApAprovDApApresDVchrLnVwDDistrLnVw insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDApAprovDApApresDVchrLnVwDDistrLnVw itemByKeys() throws JOAException;
  public IDApAprovDApApresDVchrLnVwDDistrLnVw currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDApAprovDApApresDVchrLnVwDDistrLnVw getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
