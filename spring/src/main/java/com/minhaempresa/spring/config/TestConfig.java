package com.minhaempresa.spring.config;

import com.minhaempresa.spring.infrastructure.models.Customer;
import com.minhaempresa.spring.infrastructure.models.Pizza;
import com.minhaempresa.spring.infrastructure.models.Request;
import com.minhaempresa.spring.infrastructure.repositories.CustomerRepository;
import com.minhaempresa.spring.infrastructure.repositories.PizzaRepository;
import com.minhaempresa.spring.infrastructure.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private RequestRepository requestRepository;

    @Override
    public void run(String... args) throws Exception { // Dados para os testes. Em produção esta classe não é utilizada
        Pizza pizza = new Pizza("Muzzarela", 30.50);
        Pizza pizza2 = new Pizza("Calabreza", 25.89);
        Pizza pizza3 = new Pizza("Frango com Catupiry", 50.00);
        pizzaRepository.saveAll(Arrays.asList(pizza, pizza2, pizza3));

        Customer customer = new Customer("11999999999", "Hermes", "Av. Paulista, 9999");
        customerRepository.save(customer);

        Request request = new Request(LocalDateTime.now(ZoneId.of("UTC")), 2, pizza.getPrice(), pizza, customer);
        requestRepository.save(request);
    }
}

