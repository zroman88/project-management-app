package com.romz.pma.services;

import com.romz.pma.dao.IEmployeeRepository;
import com.romz.pma.dto.IEmployeeProject;
import com.romz.pma.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author roman - Project project-management
 */

@Service
public class EmployeeService {

    private IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<IEmployeeProject> employeesProjects() {
        return employeeRepository.employeesProjects();
    }

    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee findByEmail(String value) {
        return employeeRepository.findByEmail(value);
    }

    public Page<Employee> findAll(Pageable pageAndSize) {
        return employeeRepository.findAll(pageAndSize);
    }
}
