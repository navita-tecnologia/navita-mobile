
//*****************************************************************
//* 
//* DPoAprovDPoApresCollection.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:11:38 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDPoAprovDPoApresCollection 
  {
  public long getCount() throws JOAException;
  public IDPoAprovDPoApres item(long Index) throws JOAException;
  public IDPoAprovDPoApres insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDPoAprovDPoApres itemByKeys(String BusinessUnit, String NfBrlId) throws JOAException;
  public IDPoAprovDPoApres currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDPoAprovDPoApres getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
