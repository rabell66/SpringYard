package com.example.customer.service;

import com.example.customer.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    CustomerService customerService;

    @Test
    public void testAddGet(){

        Customer newCustomer = new Customer();
        newCustomer.setFirstName("Shiela");
        newCustomer.setLastName("Sales");
        newCustomer.setEmail("ASDFASDFASD.hotmail");
        newCustomer.setPhone(1231234123);

        System.out.println("New customer" + newCustomer);
        customerService.add(newCustomer);
        System.out.println(customerService);

        List<Customer> customers = customerService.getAll();
        Customer findNewCustomer = findInList(customers, newCustomer.getFirstName(), newCustomer.getLastName(),
        newCustomer.getPhone(),newCustomer.getEmail());
        Assert.assertNotNull(findNewCustomer);



    }
    public static Customer findInList(List<Customer> customers, String first, String last ,int phone, String email) {
        // Find the new person in the list
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getFirstName().equals(first) && customer.getLastName().equals(last)) {
                return customer;
            }
        }
        return null;
    }

}
