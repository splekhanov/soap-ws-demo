package com.simple.service.jaxws.service;

import com.simple.service.jaxws.dto.CustomerDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

@WebService(name = "ICustomerService")
@SOAPBinding
public interface ICustomerService {

    @WebMethod
    CustomerDTO getCustomer(@XmlElement(name = "CustomerId", required = true) Integer id);

    @WebMethod
    ArrayList<CustomerDTO> getAllCustomers();

    @WebMethod
    String addCustomer(@XmlElement(name = "CustomerFirstName", required = true) String firstName,
                       @XmlElement(name = "CustomerLastName", required = true) String lastName,
                       @XmlElement(name = "CustomerEmail", required = true) String email);

}
