package br.com.navita.mobile.console.operator.sap.wrap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SapRow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SapRow() {
		this.rowEnvelop = new ArrayList<SapParameter>();
	}

	private List<SapParameter> rowEnvelop;

	public List<SapParameter> getRowEnvelop() {
		return rowEnvelop;
	}

	public void setRowEnvelop(List<SapParameter> row) {
		this.rowEnvelop = row;
	}

	public void add(SapParameter sapParameter) {
		this.rowEnvelop.add(sapParameter);		
	}
}
