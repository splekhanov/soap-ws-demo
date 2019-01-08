package com.simple.service.jaxws.dao;

import com.simple.service.jaxws.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerDAO {

    public CustomerDTO getCustomer(Integer id);

    public ArrayList<CustomerDTO> getAllCustomers();
}
