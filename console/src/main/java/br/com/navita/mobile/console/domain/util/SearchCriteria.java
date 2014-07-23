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
package br.com.navita.mobile.console.domain.util;


/**
 * Critérios de busca paginada.
 *
 * @author Guilherme Birckan
 */
public class SearchCriteria {

	private static final long serialVersionUID = 1L;

	/* Atributos ******************************************************************************* */

	/** Indice do primeiro resultado */
	private int pageNumber;

	/** Numero maximo de elementos a serem buscados */
	private int pageSize;

	private String text;

	private String letter;

	

	public SearchCriteria() {
		pageNumber = 1;
		pageSize = 20;		
	}

	/* Getters/Setters ************************************************************************* */

	/**
	 * @see com.navita.portal.master.view.rawdata.SearchCriteriaRaw#getPageNumber()
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @see com.navita.portal.master.view.rawdata.SearchCriteriaRaw#getOffset()
	 */
	public int getOffset() {
		return (pageNumber * pageSize == 0) ? 0 : (pageNumber * pageSize) - pageSize;
	}

	/**
	 * @see com.navita.portal.master.view.rawdata.SearchCriteriaRaw#getPageSize()
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @see com.navita.portal.master.view.rawdata.SearchCriteriaRaw#getText()
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @see com.navita.portal.master.view.rawdata.SearchCriteriaRaw#getLetter()
	 */
	public String getLetter() {
		return letter;
	}

	/**
	 * @param letter the letter to set
	 */
	public void setLetter(String letter) {
		this.letter = letter;
	}

	

	

}