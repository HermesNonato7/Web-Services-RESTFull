package com.minhaempresa.spring.application.resources;

import com.minhaempresa.spring.application.services.CustomerService;
import com.minhaempresa.spring.infrastructure.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerResource {
    @Autowired
    private CustomerService customerService;

    @GetMapping //endpoint
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customers = customerService.findAll();
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping(value = "/{id}")//endpoint
    public ResponseEntity<Customer> findById(@PathVariable String id) {
        Customer customer = customerService.findById(id);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping//endpoint
    public ResponseEntity<Customer> insert(@RequestBody Customer customer) {
        customer = customerService.customerRegistration(customer);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(customer.getTelephone())
                .toUri();
        return ResponseEntity.created(uri).body(customer);
    }

    @DeleteMapping(value = "/{id}")//endpoint
    public ResponseEntity<Void> delete(@PathVariable String id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")//endpoint
    public ResponseEntity<Customer> update(@PathVariable String id, @RequestBody Customer customer) {
        customer = customerService.update(id, customer);
        return ResponseEntity.ok().body(customer);
    }
}
