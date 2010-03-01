
//*****************************************************************
//* 
//* DAsmAprovDExApresVw3Collection.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:36:10 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDAsmAprovDExApresVw3Collection 
  {
  public long getCount() throws JOAException;
  public IDAsmAprovDExApresVw3 item(long Index) throws JOAException;
  public IDAsmAprovDExApresVw3 insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDAsmAprovDExApresVw3 itemByKeys(String SupervisorId) throws JOAException;
  public IDAsmAprovDExApresVw3 currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDAsmAprovDExApresVw3 getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
