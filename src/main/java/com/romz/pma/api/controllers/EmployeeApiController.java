package com.romz.pma.api.controllers;

import com.romz.pma.entities.Employee;
import com.romz.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author roman - Project project-management
 */
@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public Iterable<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findById(id).get();

    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody @Valid Employee employee) {
        return employeeService.save(employee);
    }

    // Full update, will trigger cascading delete
    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody @Valid Employee employee) {
        return employeeService.save(employee);
    }

    // Partial update
    @PatchMapping(path = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Employee patch(@PathVariable("id") Long id, @RequestBody @Valid Employee patchEmp) {
        Employee employee = employeeService.findById(id).get();

        if (patchEmp.getEmail() != null) {
            employee.setEmail(patchEmp.getEmail());
        }
        if (patchEmp.getFirstName() != null) {
            employee.setFirstName(patchEmp.getFirstName());
        }
        if (patchEmp.getLastName() != null) {
            employee.setLastName(patchEmp.getLastName());
        }
        if (patchEmp.getProjects() != null) {
            employee.setProjects(patchEmp.getProjects());
        }

        return employeeService.save(employee);
    }

    @DeleteMapping(value = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        try {
            employeeService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping(params = {"page", "size"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Employee> findPaginatedEmployees(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageAndSize = PageRequest.of(page, size);

        return employeeService.findAll(pageAndSize);
    }
}
