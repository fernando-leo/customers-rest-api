package com.restservice.RestApp.models;

import com.restservice.RestApp.repositories.CustomerRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CustomerTests {
    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void verificaNome() {
        Customer c = mock(Customer.class);
        c.setName("Fernando");
        verify(c).setName("Fernando");
    }

    @Test
    public void verificaPessoaFisica() {
        Customer c = mock(Customer.class);
        c.setCustomerType(CustomerType.PESSOA_JURIDICA);
        verify(c).setCustomerType(CustomerType.PESSOA_FISICA);
    }

    @Test
    public void verificaObrigatoriedadeTelefones() {
        Customer c = new Customer();

        ArrayList<Integer> phones = new ArrayList<Integer>();
        phones.add(997867172);
        phones.add(33332211);

        c.setPhone(phones);

        assertNotNull(c.getPhone());
    }

    @Test
    public void verificaMetodosAPI() {
        Customer c = new Customer();

        ArrayList<Integer> phones = new ArrayList<Integer>();
        phones.add(997867172);
        phones.add(33332211);

        c.setName("Fernando");
        c.setPhone(phones);
        c.setAddress("Rua teste, 20");
        c.setCustomerType(CustomerType.PESSOA_FISICA);
        c.setDocument("329.002.708-20");

        customerRepository = mock(CustomerRepository.class);

        customerRepository.save(c);
        assertNotNull(customerRepository.findById(1));
    }
}
