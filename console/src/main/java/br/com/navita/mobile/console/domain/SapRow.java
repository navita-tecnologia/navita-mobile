package br.com.navita.mobile.console.domain;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class SapRow extends BaseEntity {

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)	
	@OrderBy("name")
	private Set<SapParameter> attributes;
	
	public SapRow() {
		attributes =  new TreeSet<SapParameter>();
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
