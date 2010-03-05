
//*****************************************************************
//* 
//* DAsmAprovCollection.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:18:37 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DAsmAprovCollection implements IDAsmAprovCollection 
  {
  public DAsmAprovCollection(IObject oThis) { m_oThis = oThis; }

  public long getCount() throws JOAException {
    return ((Long)m_oThis.getProperty("Count")).longValue();
 }

  public IDAsmAprov item(long Index) throws JOAException {
    Object[] args = new Object[1];
    args[0] = new Long(Index);
    return (IDAsmAprov)m_oThis.invokeMethod("Item", args);
    }

  IObject m_oThis;
  }
