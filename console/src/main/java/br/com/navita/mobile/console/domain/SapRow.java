/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
