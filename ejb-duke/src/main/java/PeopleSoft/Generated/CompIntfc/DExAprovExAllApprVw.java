
//*****************************************************************
//* 
//* DExAprovExAllApprVw.java (generated)
//* 
//* Automatically generated at Wed Mar 03 14:27:00 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public class DExAprovExAllApprVw implements IDExAprovExAllApprVw 
  {
  public DExAprovExAllApprVw(IObject oThis) { m_oThis = oThis; }

  public long getItemNum() throws JOAException {
    return ((Long)m_oThis.getProperty("ItemNum")).longValue();
 }

  public String getApprTransType() throws JOAException {
    return (String)m_oThis.getProperty("APPR_TRANS_TYPE");
 }

  public void setApprTransType(String inApprTransType) throws JOAException {
    m_oThis.setProperty("APPR_TRANS_TYPE", inApprTransType);
 }

  public String getTransactionId() throws JOAException {
    return (String)m_oThis.getProperty("TRANSACTION_ID");
 }

  public void setTransactionId(String inTransactionId) throws JOAException {
    m_oThis.setProperty("TRANSACTION_ID", inTransactionId);
 }

  public String getLineSelectCb() throws JOAException {
    return (String)m_oThis.getProperty("LINE_SELECT_CB");
 }

  public void setLineSelectCb(String inLineSelectCb) throws JOAException {
    m_oThis.setProperty("LINE_SELECT_CB", inLineSelectCb);
 }

  public String getDescr() throws JOAException {
    return (String)m_oThis.getProperty("DESCR");
 }

  public void setDescr(String inDescr) throws JOAException {
    m_oThis.setProperty("DESCR", inDescr);
 }

  public String getEmplid() throws JOAException {
    return (String)m_oThis.getProperty("EMPLID");
 }

  public void setEmplid(String inEmplid) throws JOAException {
    m_oThis.setProperty("EMPLID", inEmplid);
 }

  public String getName() throws JOAException {
    return (String)m_oThis.getProperty("NAME");
 }

  public void setName(String inName) throws JOAException {
    m_oThis.setProperty("NAME", inName);
 }

  public String getSubmissionDate() throws JOAException {
    return (String)m_oThis.getProperty("SUBMISSION_DATE");
 }

  public void setSubmissionDate(String inSubmissionDate) throws JOAException {
    m_oThis.setProperty("SUBMISSION_DATE", inSubmissionDate);
 }

  public BigDecimal getTotalAmt() throws JOAException {
    return (new BigDecimal((String)m_oThis.getProperty("TOTAL_AMT")));
 }

  public void setTotalAmt(BigDecimal inTotalAmt) throws JOAException {
    m_oThis.setProperty("TOTAL_AMT", inTotalAmt.toString());
 }

  public String getCurrencyCd() throws JOAException {
    return (String)m_oThis.getProperty("CURRENCY_CD");
 }

  public void setCurrencyCd(String inCurrencyCd) throws JOAException {
    m_oThis.setProperty("CURRENCY_CD", inCurrencyCd);
 }

  public String getApprvrDescr() throws JOAException {
    return (String)m_oThis.getProperty("APPRVR_DESCR");
 }

  public void setApprvrDescr(String inApprvrDescr) throws JOAException {
    m_oThis.setProperty("APPRVR_DESCR", inApprvrDescr);
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
