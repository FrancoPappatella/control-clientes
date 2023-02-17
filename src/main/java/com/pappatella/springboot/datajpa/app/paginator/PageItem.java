package com.pappatella.springboot.datajpa.app.paginator;

import java.util.List;

public class PageItem {

	private int numero;
	private boolean actual;
	

	public PageItem(int numero, boolean actual) {
		this.numero = numero;
		this.actual = actual;
	}
	public int getNumero() {
		return numero;
	}
	public boolean isActual() {
		return actual;
	}
	
	
}