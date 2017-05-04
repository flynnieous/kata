package com.neleth.customer;

public abstract class DTOFactory<D, E> {
	
	public abstract D createDTO(E entity);

}
