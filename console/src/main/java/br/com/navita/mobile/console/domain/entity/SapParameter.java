package br.com.navita.mobile.console.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SapParameter extends BaseEntity implements Comparable<SapParameter>{

		
	@Column(nullable = false)
	private String value;
	
	public SapParameter(String name, String value) {
		setName(name);
		this.value = value;
	}

	public SapParameter() {
		
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int compareTo(SapParameter o) {
		return this.getName().compareTo(o.getName());
	}

	
	
	
	
}
