
//*****************************************************************
//* 
//* DPoAprovDGridCntrctCollection.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:11:38 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDPoAprovDGridCntrctCollection 
  {
  public long getCount() throws JOAException;
  public IDPoAprovDGridCntrct item(long Index) throws JOAException;
  public IDPoAprovDGridCntrct insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDPoAprovDGridCntrct itemByKeys() throws JOAException;
  public IDPoAprovDGridCntrct currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDPoAprovDGridCntrct getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
