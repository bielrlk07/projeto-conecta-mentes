package com.conecta_mentes.conectamentes.model;

public class ExceptionAcesso extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionAcesso(String mensagem) {
        super(mensagem);
    }
}
