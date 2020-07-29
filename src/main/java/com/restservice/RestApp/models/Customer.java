package com.restservice.RestApp.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "customer")
public class Customer {
    @GeneratedValue
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private ArrayList<Integer> phone;

    @Column(name = "address")
    private String address;

    @Enumerated
    @Column(name = "customerType", columnDefinition = "int")
    private CustomerType customerType;

    @Column(name = "document")
    private String document;

    public Customer(){}

    public Customer(String name, ArrayList<Integer> phone, String address, CustomerType customerType, String document){
        super();
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.customerType = customerType;
        this.document = document;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(ArrayList<Integer> phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}