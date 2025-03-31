package ca.uottawa.csi2132.ehotels.repositories;

import ca.uottawa.csi2132.ehotels.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insert new customer
    public void insertCustomer(Customer customer) {
        String sql = "INSERT INTO customer (SSN, full_name, address, registration_date) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                customer.getSSN(),
                customer.getFullName(),
                customer.getAddress(),
                Date.valueOf(customer.getRegistrationDate()));
    }
    public void insertCustomer2(Customer customer) {
        String sql = "INSERT INTO customer (SSN, full_name, address, registration_date) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(connection -> {
            // Use "customer_id" in lower-case (the actual column name in PostgreSQL)
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"customer_id"});
            ps.setString(1, customer.getSSN());
            ps.setString(2, customer.getFullName());
            ps.setString(3, customer.getAddress());
            ps.setDate(4, Date.valueOf(customer.getRegistrationDate()));
            return ps;
        }, keyHolder);
        
        if (keyHolder.getKey() != null) {
            customer.setCustomerId(keyHolder.getKey().longValue());
        }
    }
    

    // Get all customers
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM customer";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Customer(
                rs.getLong("customer_ID"),
                rs.getString("SSN"),
                rs.getString("full_name"),
                rs.getString("address"),
                rs.getDate("registration_date").toLocalDate()
        ));
    }

    // Get customer by ID
    public Customer getCustomerById(Long id) {
        String sql = "SELECT * FROM customer WHERE customer_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Customer(
                rs.getLong("customer_ID"),
                rs.getString("SSN"),
                rs.getString("full_name"),
                rs.getString("address"),
                rs.getDate("registration_date").toLocalDate()
        ));
    }

    // Update customer info
    public void updateCustomer(Long id, Customer customer) {
        String sql = "UPDATE customer SET SSN = ?, full_name = ?, address = ?, registration_date = ? WHERE customer_ID = ?";
        jdbcTemplate.update(sql,
                customer.getSSN(),
                customer.getFullName(),
                customer.getAddress(),
                Date.valueOf(customer.getRegistrationDate()),
                id);
    }

    // Delete customer
    public void deleteCustomer(Long id) {
        String sql = "DELETE FROM customer WHERE customer_ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
