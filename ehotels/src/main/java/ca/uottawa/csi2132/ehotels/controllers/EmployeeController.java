package ca.uottawa.csi2132.ehotels.controllers;

import ca.uottawa.csi2132.ehotels.entities.Employee;
import ca.uottawa.csi2132.ehotels.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a new employee and return the created employee (with ID)
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employeeRepository.insertEmployee(employee);
        // Here, it is assumed that the employee object now contains the generated ID.
        return ResponseEntity.ok(employee);
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    // Get an employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    // Update an employee
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeRepository.updateEmployee(id, employee);
        return ResponseEntity.ok("Employee updated");
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted");
    }

    // Assign a role to an employee
    @PostMapping("/{id}/roles")
    public ResponseEntity<String> assignRole(@PathVariable Long id, @RequestBody String role) {
        employeeRepository.addRoleToEmployee(id, role);
        return ResponseEntity.ok("Role added to employee");
    }

    // Get roles for an employee
    @GetMapping("/{id}/roles")
    public List<String> getEmployeeRoles(@PathVariable Long id) {
        return employeeRepository.getRolesByEmployeeId(id);
    }

    // Assign manager to a hotel
    @PostMapping("/{id}/assign-manager")
    public ResponseEntity<String> assignAsManager(@PathVariable Long id, @RequestParam Long hotelId) {
        employeeRepository.assignManagerToHotel(id, hotelId);
        return ResponseEntity.ok("Employee assigned as manager to hotel " + hotelId);
    }
}
