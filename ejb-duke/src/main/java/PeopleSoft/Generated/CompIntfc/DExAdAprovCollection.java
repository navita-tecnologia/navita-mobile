
//*****************************************************************
//* 
//* DExAdAprovCollection.java (generated)
//* 
//* Automatically generated at Wed Mar 03 14:27:00 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DExAdAprovCollection implements IDExAdAprovCollection 
  {
  public DExAdAprovCollection(IObject oThis) { m_oThis = oThis; }

  public long getCount() throws JOAException {
    return ((Long)m_oThis.getProperty("Count")).longValue();
 }

  public IDExAdAprov item(long Index) throws JOAException {
    Object[] args = new Object[1];
    args[0] = new Long(Index);
    return (IDExAdAprov)m_oThis.invokeMethod("Item", args);
    }

  IObject m_oThis;
  }
