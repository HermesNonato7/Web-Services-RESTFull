package com.minhaempresa.spring.application.dtos;

/*
Padrão de projeto: DTO – Data Transfer Object (Objeto de Transferência de Dados)
é um padrão de arquitetura de objetos que agregam e encapsulam dados para transferência.

Basicamente é uma classe com atributos simples que é utilizada para
otimizar a comunicação entre o client e o servidor.
*/
public class RequestDTO {
    private Integer amount;
    private Double price;
    private Long pizzaId;
    private String telephone;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

