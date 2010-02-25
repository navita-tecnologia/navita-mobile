
//*****************************************************************
//* 
//* DApAprovDApApres.java (generated)
//* 
//* Automatically generated at Tue Feb 23 17:36:10 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDApAprovDApApres 
  {
  public long getItemNum() throws JOAException;
  public String getSupervisorId() throws JOAException;
  public void setSupervisorId(String inSupervisorId) throws JOAException;
  public String getMessageText() throws JOAException;
  public void setMessageText(String inMessageText) throws JOAException;
  public String getDVchrReject() throws JOAException;
  public void setDVchrReject(String inDVchrReject) throws JOAException;
  public String getDVchrApproval() throws JOAException;
  public void setDVchrApproval(String inDVchrApproval) throws JOAException;
  public String getDAprovedFlg() throws JOAException;
  public void setDAprovedFlg(String inDAprovedFlg) throws JOAException;
  public BigDecimal getGrossAmt() throws JOAException;
  public void setGrossAmt(BigDecimal inGrossAmt) throws JOAException;
  public String getSendContactId() throws JOAException;
  public void setSendContactId(String inSendContactId) throws JOAException;
  public String getForwardSw() throws JOAException;
  public void setForwardSw(String inForwardSw) throws JOAException;
  public String getBusinessUnit() throws JOAException;
  public void setBusinessUnit(String inBusinessUnit) throws JOAException;
  public String getVoucherId() throws JOAException;
  public void setVoucherId(String inVoucherId) throws JOAException;
  public String getEdittable40() throws JOAException;
  public void setEdittable40(String inEdittable40) throws JOAException;
  public IDApAprovDApApresDPymntXrefVwCollection getDPymntXrefVw() throws JOAException;
  public IDApAprovDApApresDVchrLnVwCollection getDVchrLnVw() throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
