
//*****************************************************************
//* 
//* DAsmAprovDAsmApres.java (generated)
//* 
//* Automatically generated at Thu Feb 25 10:18:37 2010
//* 
//* Copyright (c) 2000, 2006, Oracle. All rights reserved.
//****************************************************************


package PeopleSoft.Generated.CompIntfc;

import java.math.*;
import psft.pt8.joa.*;

public interface IDAsmAprovDAsmApres 
  {
  public long getItemNum() throws JOAException;
  public String getSupervisorId() throws JOAException;
  public void setSupervisorId(String inSupervisorId) throws JOAException;
  public String getSel() throws JOAException;
  public void setSel(String inSel) throws JOAException;
  public String getApprovePb() throws JOAException;
  public void setApprovePb(String inApprovePb) throws JOAException;
  public String getDenyPb() throws JOAException;
  public void setDenyPb(String inDenyPb) throws JOAException;
  public BigDecimal getDAsmAmtTtl() throws JOAException;
  public void setDAsmAmtTtl(BigDecimal inDAsmAmtTtl) throws JOAException;
  public String getVendorName1() throws JOAException;
  public void setVendorName1(String inVendorName1) throws JOAException;
  public String getSendContactId() throws JOAException;
  public void setSendContactId(String inSendContactId) throws JOAException;
  public String getForwardSw() throws JOAException;
  public void setForwardSw(String inForwardSw) throws JOAException;
  public String getEmplid() throws JOAException;
  public void setEmplid(String inEmplid) throws JOAException;
  public String getBusinessUnit1() throws JOAException;
  public void setBusinessUnit1(String inBusinessUnit1) throws JOAException;
  public String getDNumAsm() throws JOAException;
  public void setDNumAsm(String inDNumAsm) throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
