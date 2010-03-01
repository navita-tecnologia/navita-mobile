package br.com.foo;

import java.io.Serializable;
import java.util.Date;

public class OutroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int num1;
	private Date d1;
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public Date getD1() {
		return d1;
	}
	public void setD1(Date d1) {
		this.d1 = d1;
	}
	
}
