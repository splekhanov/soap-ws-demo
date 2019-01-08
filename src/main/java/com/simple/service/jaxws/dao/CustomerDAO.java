package com.simple.service.jaxws.dao;

import com.simple.service.jaxws.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerDAO {

    CustomerDTO getCustomer(Integer id);

    ArrayList<CustomerDTO> getAllCustomers();

    String addCustomer(String firstName, String lastName, String email);
}
