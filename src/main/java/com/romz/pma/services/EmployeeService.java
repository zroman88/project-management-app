package com.romz.pma.services;

import com.romz.pma.dao.IEmployeeRepository;
import com.romz.pma.dto.IEmployeeProject;
import com.romz.pma.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author roman - Project project-management
 */
@Service
public class EmployeeService {

    private IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<IEmployeeProject> employeesProjects() {
        return employeeRepository.employeesProjects();
    }
}
