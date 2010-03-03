
//*****************************************************************
//* 
//* DApAprovCollection.java (generated)
//* 
//* Automatically generated at Thu Feb 25 11:13:30 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DApAprovCollection implements IDApAprovCollection 
  {
  public DApAprovCollection(IObject oThis) { m_oThis = oThis; }

  public long getCount() throws JOAException {
    return ((Long)m_oThis.getProperty("Count")).longValue();
 }

  public IDApAprov item(long Index) throws JOAException {
    Object[] args = new Object[1];
    args[0] = new Long(Index);
    return (IDApAprov)m_oThis.invokeMethod("Item", args);
    }

  IObject m_oThis;
  }
