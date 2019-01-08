package com.simple.service.jaxws.service;

import com.simple.service.jaxws.dto.CustomerDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

@WebService(name = "ICustomerService")
@SOAPBinding
public interface ICustomerService {

    @WebMethod
    public CustomerDTO getCustomer(Integer id);

    @WebMethod
    public ArrayList<CustomerDTO> getAllCustomers();

}
