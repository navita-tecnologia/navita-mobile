
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

public interface IDPoAprovDPoApresBrlDistribLn 
  {
  public long getItemNum() throws JOAException;
  public BigDecimal getDistribLineNum() throws JOAException;
  public void setDistribLineNum(BigDecimal inDistribLineNum) throws JOAException;
  public String getAccount() throws JOAException;
  public void setAccount(String inAccount) throws JOAException;
  public BigDecimal getMerchandiseAmt() throws JOAException;
  public void setMerchandiseAmt(BigDecimal inMerchandiseAmt) throws JOAException;
  public String getDeptid() throws JOAException;
  public void setDeptid(String inDeptid) throws JOAException;
  public String getProjectId() throws JOAException;
  public void setProjectId(String inProjectId) throws JOAException;
  public String getProduct() throws JOAException;
  public void setProduct(String inProduct) throws JOAException;
  public String getDeptidDescr() throws JOAException;
  public void setDeptidDescr(String inDeptidDescr) throws JOAException;
  public Object getPropertyByName(String Name) throws JOAException;
  public long setPropertyByName(String Name, Object Value) throws JOAException;
  public ICompIntfcPropertyInfo getPropertyInfoByName(String Name) throws JOAException;
  }
