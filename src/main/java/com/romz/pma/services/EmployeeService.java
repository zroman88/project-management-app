package com.romz.pma.services;

import com.romz.pma.dao.IEmployeeRepository;
import com.romz.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author roman - Project project-management
 */
@Service
public class EmployeeService {
    // Field injection
//    @Autowired
//    IEmployeeRepository employeeRepository;

    @Autowired
    IStaffRepository iStaffRepository;

//    //Constructor injection
//    public EmployeeService(IEmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    //Setter injection
//    @Autowired
//    public void setEmployeeRepository(IEmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
}
