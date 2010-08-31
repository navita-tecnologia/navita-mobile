package br.com.navita.mobile.console.domain;

import javax.persistence.Entity;

@Entity
public class SapTableField extends BaseEntity implements Comparable<SapTableField>{

	@Override
	public int compareTo(SapTableField o) {
		
		return this.getName().compareTo(o.getName());
	}

	
}
