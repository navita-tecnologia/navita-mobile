
//*****************************************************************
//* 
//* DAsmAprovDAsmVendorVwCollection.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:18:37 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DAsmAprovDAsmVendorVwCollection implements IDAsmAprovDAsmVendorVwCollection 
  {
  public DAsmAprovDAsmVendorVwCollection(IObject oThis) { m_oThis = oThis; }

  public long getCount() throws JOAException {
    return ((Long)m_oThis.getProperty("Count")).longValue();
 }

  public IDAsmAprovDAsmVendorVw item(long Index) throws JOAException {
    Object[] args = new Object[1];
    args[0] = new Long(Index);
    return (IDAsmAprovDAsmVendorVw)m_oThis.invokeMethod("Item", args);
    }

  public IDAsmAprovDAsmVendorVw insertItem(long Index) throws JOAException {
    Object[] args = new Object[1];
    args[0] = new Long(Index);
    return (IDAsmAprovDAsmVendorVw)m_oThis.invokeMethod("InsertItem", args);
    }

  public boolean deleteItem(long Index) throws JOAException {
    Object[] args = new Object[1];
    args[0] = new Long(Index);
    return ((Boolean)(m_oThis.invokeMethod("DeleteItem", args))).booleanValue();
    }

  public IDAsmAprovDAsmVendorVw itemByKeys(String DNumAsm1) throws JOAException {
    Object[] args = new Object[1];
    args[0] = DNumAsm1;
    return (IDAsmAprovDAsmVendorVw)m_oThis.invokeMethod("ItemByKeys", args);
    }

  public IDAsmAprovDAsmVendorVw currentItem() throws JOAException {
    Object[] args = new Object[0];
    return (IDAsmAprovDAsmVendorVw)m_oThis.invokeMethod("CurrentItem", args);
    }

  public long currentItemNum() throws JOAException {
    Object[] args = new Object[0];
    return ((Long)(m_oThis.invokeMethod("CurrentItemNum", args))).longValue();
    }

  public IDAsmAprovDAsmVendorVw getEffectiveItem(String Date, long SeqNum) throws JOAException {
    Object[] args = new Object[2];
    args[0] = Date;
    args[1] = new Long(SeqNum);
    return (IDAsmAprovDAsmVendorVw)m_oThis.invokeMethod("GetEffectiveItem", args);
    }

  public long getEffectiveItemNum(String Date, long SeqNum) throws JOAException {
    Object[] args = new Object[2];
    args[0] = Date;
    args[1] = new Long(SeqNum);
    return ((Long)(m_oThis.invokeMethod("GetEffectiveItemNum", args))).longValue();
    }

  IObject m_oThis;
  }
