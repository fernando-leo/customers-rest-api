package com.restservice.RestApp.controllers;

import com.restservice.RestApp.models.Customer;
import com.restservice.RestApp.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    private CustomerRepository _customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        super();
        _customerRepository = customerRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        _customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> customers = new ArrayList<>();
        customers = _customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "{/id}")
    public ResponseEntity<Optional<Customer>> getById(@PathVariable Integer id){
        Optional<Customer> customer;
        try{
            customer = _customerRepository.findById(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}