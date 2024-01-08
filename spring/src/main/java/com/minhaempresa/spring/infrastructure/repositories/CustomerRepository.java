package com.minhaempresa.spring.infrastructure.repositories;

import com.minhaempresa.spring.infrastructure.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
