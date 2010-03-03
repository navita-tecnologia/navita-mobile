
//*****************************************************************
//* 
//* DExErAprovExSheetLine.java (generated)
//* 
//* Automatically generated at Wed Mar 03 14:27:00 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DExErAprovExSheetLine implements IDExErAprovExSheetLine 
  {
  public DExErAprovExSheetLine(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getActivityId() throws JOAException {
    return (String)m_oThis.getProperty("ACTIVITY_ID");
 }

  public void setActivityId(String inActivityId) throws JOAException {
    m_oThis.setProperty("ACTIVITY_ID", inActivityId);
 }

  public String getApproveFlag() throws JOAException {
    return (String)m_oThis.getProperty("APPROVE_FLAG");
 }

  public void setApproveFlag(String inApproveFlag) throws JOAException {
    m_oThis.setProperty("APPROVE_FLAG", inApproveFlag);
 }

  public String getBusinessUnitPc() throws JOAException {
    return (String)m_oThis.getProperty("BUSINESS_UNIT_PC");
 }

  public void setBusinessUnitPc(String inBusinessUnitPc) throws JOAException {
    m_oThis.setProperty("BUSINESS_UNIT_PC", inBusinessUnitPc);
 }

  public String getProjectId() throws JOAException {
    return (String)m_oThis.getProperty("PROJECT_ID");
 }

  public void setProjectId(String inProjectId) throws JOAException {
    m_oThis.setProperty("PROJECT_ID", inProjectId);
 }

  public String getExpenseType() throws JOAException {
    return (String)m_oThis.getProperty("EXPENSE_TYPE");
 }

  public void setExpenseType(String inExpenseType) throws JOAException {
    m_oThis.setProperty("EXPENSE_TYPE", inExpenseType);
 }

  public String getTransDt() throws JOAException {
    return (String)m_oThis.getProperty("TRANS_DT");
 }

  public void setTransDt(String inTransDt) throws JOAException {
    m_oThis.setProperty("TRANS_DT", inTransDt);
 }

  public BigDecimal getMonetaryAmount() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("MONETARY_AMOUNT")));
 }

  public void setMonetaryAmount(BigDecimal inMonetaryAmount) throws JOAException {
    m_oThis.setProperty("MONETARY_AMOUNT", inMonetaryAmount.toString());
 }

  public String getCurrencyCd() throws JOAException {
    return (String)m_oThis.getProperty("CURRENCY_CD");
 }

  public void setCurrencyCd(String inCurrencyCd) throws JOAException {
    m_oThis.setProperty("CURRENCY_CD", inCurrencyCd);
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
