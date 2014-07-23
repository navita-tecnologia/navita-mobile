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

import java.util.List;

/**
 * Resultado de busca paginada.
 *
 * @author Guilherme Birckan
 */
public class SearchResultPage<T> {

	private static final long serialVersionUID = 1L;

	/* Atributos ******************************************************************************* */

	/** Número total de elementos */
	private long totalElements;

	/** Elementos da página atual */
	private List<T> elementsThisPage;

	/** Critérios da busca */
	private SearchCriteria criteria;

	/* Construtores **************************************************************************** */

	/**
	 * @param criteria critérios utilizados na busca
	 * @param totalElements número total de resultados da busca
	 * @param elementsThisPage resultados da página atual
	 */
	public SearchResultPage(SearchCriteria criteria, long totalElements, List<T> elementsThisPage) {
		super();
		this.criteria = criteria;
		this.totalElements = totalElements;
		this.elementsThisPage = elementsThisPage;
	}

	/* Getters/Setters ************************************************************************* */

	/**
	 * @return
	 */
	public long getTotalElements() {
		return totalElements;
	}

	/**
	 * @return
	 */
	public List<T> getElementsThisPage() {
		return elementsThisPage;
	}

	/**
	 * @return
	 */
	public SearchCriteria getSearchCriteria() {
		return criteria;
	}

	/**
	 * @return
	 */
	public boolean isFirstPage() {
		return (getPageNumber() == 1);
	}

	/**
	 * @return
	 */
	public boolean isLastPage() {
		return (getNumPages() == 0) || (getPageNumber() == getNumPages());
	}

	/**
	 * @return
	 */
	public int getPageNumber() {
		return criteria.getPageNumber();
	}

	/**
	 * @return
	 */
	public int getPageSize() {
		return criteria.getPageSize();
	}

	/**
	 * @return
	 */
	public long getNumPages() {
		long numPages = totalElements / getPageSize();
		if (totalElements % getPageSize() != 0) {
			numPages ++;
		}
		return numPages == 0 ? 1 : numPages;
	}

	/**
	 * @return
	 */
	public int getFirstElementInPageIndex() {
		return elementsThisPage.isEmpty() ? 0 : criteria.getOffset() + 1;
	}

	/**
	 * @return
	 */
	public int getLastElementInPageIndex() {
		return criteria.getOffset() + elementsThisPage.size();
	}

}
