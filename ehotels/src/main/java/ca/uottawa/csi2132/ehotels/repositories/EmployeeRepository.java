package ca.uottawa.csi2132.ehotels.repositories;

import ca.uottawa.csi2132.ehotels.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insert a new employee
    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO employee (SSN, full_name, address) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getSSN(), employee.getFullName(), employee.getAddress());
    }

    // Assign a role to an employee
    public void addRoleToEmployee(Long employeeId, String role) {
        String sql = "INSERT INTO employee_role (employee_ID, role) VALUES (?, ?)";
        jdbcTemplate.update(sql, employeeId, role);
    }

    // Set employee as manager of a hotel
    public void assignManagerToHotel(Long employeeId, Long hotelId) {
        String sql = "INSERT INTO manager (employee_ID, hotel_ID) VALUES (?, ?)";
        jdbcTemplate.update(sql, employeeId, hotelId);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Employee(
                rs.getLong("employee_ID"),
                rs.getInt("SSN"),
                rs.getString("full_name"),
                rs.getString("address")
        ));
    }

    // Get employee by ID
    public Employee getEmployeeById(Long id) {
        String sql = "SELECT * FROM employee WHERE employee_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Employee(
                rs.getLong("employee_ID"),
                rs.getInt("SSN"),
                rs.getString("full_name"),
                rs.getString("address")
        ));
    }

    // Update employee
    public void updateEmployee(Long id, Employee employee) {
        String sql = "UPDATE employee SET SSN = ?, full_name = ?, address = ? WHERE employee_ID = ?";
        jdbcTemplate.update(sql, employee.getSSN(), employee.getFullName(), employee.getAddress(), id);
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        String sql = "DELETE FROM employee WHERE employee_ID = ?";
        jdbcTemplate.update(sql, id);
    }

    // Get all roles for an employee
    public List<String> getRolesByEmployeeId(Long employeeId) {
        String sql = "SELECT role FROM employee_role WHERE employee_ID = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{employeeId}, String.class);
    }
}
