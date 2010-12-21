package br.jpa.test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;



public class TesteBeanUtil {

	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		
		MyBean b = new MyBean();
		BeanUtils.setProperty(b, "c1", "tese");


	}

}
