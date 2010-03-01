
//*****************************************************************
//* 
//* DPoAprovDAprovrecbCollection.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:37:19 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDPoAprovDAprovrecbCollection 
  {
  public long getCount() throws JOAException;
  public IDPoAprovDAprovrecb item(long Index) throws JOAException;
  public IDPoAprovDAprovrecb insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDPoAprovDAprovrecb itemByKeys(String DExDtEncam) throws JOAException;
  public IDPoAprovDAprovrecb currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDPoAprovDAprovrecb getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
