package model.exceptions;

//extends exception - é obrigada a tratar
//Runtime excleption não precisa tratar
public class DomainException extends Exception {

	/**
	 * versão da classe
	 */
	private static final long serialVersionUID = 1L;
	//lançada na entidade de domínio
	
	public DomainException(String msg) {
		super(msg);
	}
	
	

}
