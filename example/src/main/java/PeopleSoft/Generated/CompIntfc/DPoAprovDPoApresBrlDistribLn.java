
//*****************************************************************
//* 
//* DPoAprovDPoApresBrlDistribLn.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:37:19 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DPoAprovDPoApresBrlDistribLn implements IDPoAprovDPoApresBrlDistribLn 
  {
  public DPoAprovDPoApresBrlDistribLn(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public BigDecimal getDistribLineNum() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("DISTRIB_LINE_NUM")));
 }

  public void setDistribLineNum(BigDecimal inDistribLineNum) throws JOAException {
    m_oThis.setProperty("DISTRIB_LINE_NUM", inDistribLineNum.toString());
 }

  public String getAccount() throws JOAException {
    return (String)m_oThis.getProperty("ACCOUNT");
 }

  public void setAccount(String inAccount) throws JOAException {
    m_oThis.setProperty("ACCOUNT", inAccount);
 }

  public BigDecimal getMerchandiseAmt() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("MERCHANDISE_AMT")));
 }

  public void setMerchandiseAmt(BigDecimal inMerchandiseAmt) throws JOAException {
    m_oThis.setProperty("MERCHANDISE_AMT", inMerchandiseAmt.toString());
 }

  public String getDeptid() throws JOAException {
    return (String)m_oThis.getProperty("DEPTID");
 }

  public void setDeptid(String inDeptid) throws JOAException {
    m_oThis.setProperty("DEPTID", inDeptid);
 }

  public String getProjectId() throws JOAException {
    return (String)m_oThis.getProperty("PROJECT_ID");
 }

  public void setProjectId(String inProjectId) throws JOAException {
    m_oThis.setProperty("PROJECT_ID", inProjectId);
 }

  public String getProduct() throws JOAException {
    return (String)m_oThis.getProperty("PRODUCT");
 }

  public void setProduct(String inProduct) throws JOAException {
    m_oThis.setProperty("PRODUCT", inProduct);
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
