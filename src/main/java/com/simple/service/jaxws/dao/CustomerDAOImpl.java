package com.simple.service.jaxws.dao;

import com.simple.service.jaxws.assembler.CustomerAssembler;
import com.simple.service.jaxws.dto.CustomerDTO;
import com.simple.service.jaxws.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(value = "transactionManager")
    public CustomerDTO getCustomer(Integer theId) {

        if (theId == null) {
            throw new ServiceException("Request has been rejected. CustomerId parameter is required");
        }

        CustomerDTO customerDTO = null;
        Session currentSession = sessionFactory.getCurrentSession();
        Customer theCustomer = currentSession.get(Customer.class, theId);
        if (theCustomer == null) {
            throw new ServiceException("No user with id " + theId + " has been found");
        }
        CustomerAssembler customerAssembler = new CustomerAssembler();
        customerDTO = customerAssembler.entityToDTO(theCustomer);
        return customerDTO;
    }

    @Override
    @Transactional(value = "transactionManager")
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers;
        List<CustomerDTO> allCustomersDTO = new ArrayList<>();
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> theQuery =
                currentSession.createQuery("from Customer order by id",
                        Customer.class);

        allCustomers = theQuery.getResultList();
        if (allCustomers.size() == 0) {
            throw new ServiceException("No users have been found");
        }
        allCustomersDTO = allCustomers.stream().map(c -> new CustomerAssembler().entityToDTO(c)).collect(Collectors.toList());
        return new ArrayList<>(allCustomersDTO);
    }

    @Override
    @Transactional(value = "transactionManager")
    public String addCustomer(String firstName, String lastName, String email) {

        Customer theCustomer = new Customer();

        theCustomer.setFirstName(firstName);
        theCustomer.setLastName(lastName);
        theCustomer.setEmail(email);

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);

        Integer lastId = ((BigInteger) currentSession.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
        return "New user has been added successfully. Obtained ID: " + lastId;
    }

}
