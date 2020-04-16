package com.romz.pma.validators;

import com.romz.pma.entities.Employee;
import com.romz.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author roman - Project project-management
 */
public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

    @Autowired
    EmployeeService employeeService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.printf("Entered validation method -> ");

        Employee emp = employeeService.findByEmail(value);

        return emp == null;
    }
}
