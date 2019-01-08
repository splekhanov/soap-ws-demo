package com.simple.service.jaxws.service;

import com.simple.service.jaxws.dao.CustomerDAO;
import com.simple.service.jaxws.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.ArrayList;

@Service
@WebService(endpointInterface = "com.simple.service.jaxws.service.ICustomerService")
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public CustomerDTO getCustomer(Integer theId) {
        return customerDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public ArrayList<CustomerDTO> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    @Transactional
    public String addCustomer(String firstName, String lastName, String email) {
        return customerDAO.addCustomer(firstName, lastName, email);
    }

}
