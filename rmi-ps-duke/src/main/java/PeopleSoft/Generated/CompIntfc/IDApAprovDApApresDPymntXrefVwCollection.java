
//*****************************************************************
//* 
//* DApAprovDApApresDPymntXrefVwCollection.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:36:10 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDApAprovDApApresDPymntXrefVwCollection 
  {
  public long getCount() throws JOAException;
  public IDApAprovDApApresDPymntXrefVw item(long Index) throws JOAException;
  public IDApAprovDApApresDPymntXrefVw insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDApAprovDApApresDPymntXrefVw itemByKeys() throws JOAException;
  public IDApAprovDApApresDPymntXrefVw currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDApAprovDApApresDPymntXrefVw getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
