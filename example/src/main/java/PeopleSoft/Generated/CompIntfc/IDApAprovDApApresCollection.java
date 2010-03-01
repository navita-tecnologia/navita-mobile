
//*****************************************************************
//* 
//* DApAprovDApApresCollection.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:36:10 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDApAprovDApApresCollection 
  {
  public long getCount() throws JOAException;
  public IDApAprovDApApres item(long Index) throws JOAException;
  public IDApAprovDApApres insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDApAprovDApApres itemByKeys(String BusinessUnit, String VoucherId) throws JOAException;
  public IDApAprovDApApres currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDApAprovDApApres getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
