package br.com.navita.mobile.console.domain.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SapRow extends BaseEntity {

	@OneToMany(cascade = CascadeType.ALL, mappedBy="sapRow")	
	private Set<SapParameter> attributes;
	
	@OneToOne
	private SapTable sapTable;

	public Set<SapParameter> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<SapParameter> attributes) {
		this.attributes = attributes;
	}

	public SapTable getSapTable() {
		return sapTable;
	}

	public void setSapTable(SapTable sapTable) {
		this.sapTable = sapTable;
	}
	
	
	
	
}
