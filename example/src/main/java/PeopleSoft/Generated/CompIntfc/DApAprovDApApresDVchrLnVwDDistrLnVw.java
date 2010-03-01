
//*****************************************************************
//* 
//* DApAprovDApApresDVchrLnVwDDistrLnVw.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:36:10 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DApAprovDApApresDVchrLnVwDDistrLnVw implements IDApAprovDApApresDVchrLnVwDDistrLnVw 
  {
  public DApAprovDApApresDVchrLnVwDDistrLnVw(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getAccount() throws JOAException {
    return (String)m_oThis.getProperty("ACCOUNT");
 }

  public void setAccount(String inAccount) throws JOAException {
    m_oThis.setProperty("ACCOUNT", inAccount);
 }

  public String getDeptid() throws JOAException {
    return (String)m_oThis.getProperty("DEPTID");
 }

  public void setDeptid(String inDeptid) throws JOAException {
    m_oThis.setProperty("DEPTID", inDeptid);
 }

  public String getProduct() throws JOAException {
    return (String)m_oThis.getProperty("PRODUCT");
 }

  public void setProduct(String inProduct) throws JOAException {
    m_oThis.setProperty("PRODUCT", inProduct);
 }

  public String getProjectId() throws JOAException {
    return (String)m_oThis.getProperty("PROJECT_ID");
 }

  public void setProjectId(String inProjectId) throws JOAException {
    m_oThis.setProperty("PROJECT_ID", inProjectId);
 }

  public BigDecimal getMonetaryAmount2() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("MONETARY_AMOUNT_2")));
 }

  public void setMonetaryAmount2(BigDecimal inMonetaryAmount2) throws JOAException {
    m_oThis.setProperty("MONETARY_AMOUNT_2", inMonetaryAmount2.toString());
 }

  public String getDeptidDescr() throws JOAException {
    return (String)m_oThis.getProperty("DEPTID_DESCR");
 }

  public void setDeptidDescr(String inDeptidDescr) throws JOAException {
    m_oThis.setProperty("DEPTID_DESCR", inDeptidDescr);
 }

  public Object getPropertyByName(String Name) throws JOAException {
    Object[] args = new Object[1];
    args[0] = Name;
    return (Object)m_oThis.invokeMethod("GetPropertyByName", args);
    }

  public long setPropertyByName(String Name, Object Value) throws JOAException {
    Object[] args = new Object[2];
    args[0] = Name;
    args[1] = Value;
    return ((Long)(m_oThis.invokeMethod("SetPropertyByName", args))).longValue();
    }

  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException {
    Object[] args = new Object[1];
    args[0] = Name;
    return (ICompIntfcPropertyInfo)m_oThis.invokeMethod("GetPropertyInfoByName", args);
    }

  IObject m_oThis;
  }
