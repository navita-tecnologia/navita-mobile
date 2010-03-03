
//*****************************************************************
//* 
//* DPoAprovDPoApres.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:37:19 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDPoAprovDPoApres 
  {
  public long getItemNum() throws JOAException;
  public String getSupervisorId() throws JOAException;
  public void setSupervisorId(String inSupervisorId) throws JOAException;
  public String getDRecbReject() throws JOAException;
  public void setDRecbReject(String inDRecbReject) throws JOAException;
  public String getDRecbApproval() throws JOAException;
  public void setDRecbApproval(String inDRecbApproval) throws JOAException;
  public String getDAprovedFlg() throws JOAException;
  public void setDAprovedFlg(String inDAprovedFlg) throws JOAException;
  public String getCntrctId() throws JOAException;
  public void setCntrctId(String inCntrctId) throws JOAException;
  public String getCntrctExpireDt() throws JOAException;
  public void setCntrctExpireDt(String inCntrctExpireDt) throws JOAException;
  public String getDescr1002() throws JOAException;
  public void setDescr1002(String inDescr1002) throws JOAException;
  public BigDecimal getGrossAmt() throws JOAException;
  public void setGrossAmt(BigDecimal inGrossAmt) throws JOAException;
  public String getVendorName1() throws JOAException;
  public void setVendorName1(String inVendorName1) throws JOAException;
  public String getSendContactId() throws JOAException;
  public void setSendContactId(String inSendContactId) throws JOAException;
  public String getForwardSw() throws JOAException;
  public void setForwardSw(String inForwardSw) throws JOAException;
  public String getCntrctExpiryFlg() throws JOAException;
  public void setCntrctExpiryFlg(String inCntrctExpiryFlg) throws JOAException;
  public String getCancel() throws JOAException;
  public void setCancel(String inCancel) throws JOAException;
  public String getEmplid() throws JOAException;
  public void setEmplid(String inEmplid) throws JOAException;
  public String getBusinessUnit() throws JOAException;
  public void setBusinessUnit(String inBusinessUnit) throws JOAException;
  public String getNfBrlId() throws JOAException;
  public void setNfBrlId(String inNfBrlId) throws JOAException;
  public String getDDescr500() throws JOAException;
  public void setDDescr500(String inDDescr500) throws JOAException;
  public IDPoAprovDPoApresDPoAprdetVwCollection getDPoAprdetVw() throws JOAException;
  public IDPoAprovDPoApresBrlDistribLnCollection getBrlDistribLn() throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
