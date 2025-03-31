package ca.uottawa.csi2132.ehotels.controllers;

import ca.uottawa.csi2132.ehotels.entities.Customer;
import ca.uottawa.csi2132.ehotels.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Create a new customer
    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        customerRepository.insertCustomer(customer);
        return ResponseEntity.ok("Customer created");
    }
    @PostMapping("/with-id")
    public ResponseEntity<Customer> createCustomer2(@RequestBody Customer customer) {
        customerRepository.insertCustomer2(customer);
        // Assumes the customer object is updated with the generated ID
        return ResponseEntity.ok(customer);
    }
    

    // Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    // Get a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    // Update a customer
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customerRepository.updateCustomer(id, customer);
        return ResponseEntity.ok("Customer updated");
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted");
    }
}
