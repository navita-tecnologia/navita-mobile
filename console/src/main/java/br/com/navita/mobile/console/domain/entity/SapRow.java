package br.com.navita.mobile.console.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class SapRow extends BaseEntity {

	@OneToMany(cascade = CascadeType.ALL)	
	private Set<SapParameter> attributes;
	
	public SapRow() {
		attributes = new HashSet<SapParameter>();
	}
	
	public void addAttribute(SapParameter attribute){
		attributes.add(attribute);
	}
	
	public Set<SapParameter> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<SapParameter> attributes) {
		this.attributes = attributes;
	}

	
	
	
	
	
}
