
//*****************************************************************
//* 
//* DApAprovDExApresVw3Collection.java (generated)
//* 
//* Automatically generated at Thu Feb 25 11:13:30 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDApAprovDExApresVw3Collection 
  {
  public long getCount() throws JOAException;
  public IDApAprovDExApresVw3 item(long Index) throws JOAException;
  public IDApAprovDExApresVw3 insertItem(long Index) throws JOAException;
  public boolean deleteItem(long Index) throws JOAException;
  public IDApAprovDExApresVw3 itemByKeys(String SupervisorId) throws JOAException;
  public IDApAprovDExApresVw3 currentItem() throws JOAException;
  public long currentItemNum() throws JOAException;
  public IDApAprovDExApresVw3 getEffectiveItem(String Date, long SeqNum) throws JOAException;
  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException;
  }
