
//*****************************************************************
//* 
//* DAsmAprovDAsmApresCollection.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:18:37 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDAsmAprovDAsmApresCollection 
  {
  public long getCount() throws JOAException;
  public IDAsmAprovDAsmApres item(long Index) throws JOAException;
  public IDAsmAprovDAsmApres insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDAsmAprovDAsmApres itemByKeys(String BusinessUnit1, String DNumAsm) throws JOAException;
  public IDAsmAprovDAsmApres currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDAsmAprovDAsmApres getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
