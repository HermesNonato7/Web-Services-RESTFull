package com.minhaempresa.spring.application.services;

import com.minhaempresa.spring.application.services.exceptions.DatabaseException;
import com.minhaempresa.spring.application.services.exceptions.ResourceNotFoundException;
import com.minhaempresa.spring.infrastructure.models.Customer;
import com.minhaempresa.spring.infrastructure.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
    Esta classe representa os serviços disponíveis para o cadastro do cliente.
*/
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer customerRegistration(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(String id) {
        Optional<Customer> optional = customerRepository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer update(String id, Customer customer) {
        try {
            Customer entity = customerRepository.getReferenceById(id);
            updateEntity(entity, customer);
            return customerRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateEntity(Customer entity, Customer customer) {
        entity.setAddress(customer.getAddress());
        entity.setName(customer.getName());
    }

    public void deleteById(String id) {
        try {
            customerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}

