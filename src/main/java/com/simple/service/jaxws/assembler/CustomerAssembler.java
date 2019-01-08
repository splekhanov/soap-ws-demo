package com.simple.service.jaxws.assembler;

import com.simple.service.jaxws.dto.CustomerDTO;
import com.simple.service.jaxws.entities.Customer;

public class CustomerAssembler {

    public Customer customerToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }

    public CustomerDTO entityToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        return customerDTO;
    }
}
