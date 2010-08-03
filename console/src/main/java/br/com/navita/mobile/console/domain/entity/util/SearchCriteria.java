package br.com.navita.mobile.console.domain.entity.util;


/**
 * Critérios de busca paginada.
 *
 * @author Guilherme Birckan
 */
public class SearchCriteria {

	private static final long serialVersionUID = 1L;

	/* Atributos ******************************************************************************* */

	/** Índice do primeiro resultado */
	private int pageNumber;

	/** Número máximo de elementos a serem buscados */
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