package com.neleth.customer;

import com.neleth.customer.Customer;

public class CustomerDTOFactory extends DTOFactory<CustomerDTO, Customer> {

	@Override
	public CustomerDTO createDTO(Customer entity) {
		return new CustomerDTO(entity);
	}

}
