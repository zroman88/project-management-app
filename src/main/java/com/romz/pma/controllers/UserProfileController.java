package com.romz.pma.controllers;

import com.romz.pma.entities.UserAccount;
import com.romz.pma.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author roman - Project project-management
 */

@RestController
public class UserProfileController {

    @Autowired
    private UserAccountService accountService;

    @GetMapping(value = "/app-api/users/user/{id}", produces = "application/json")
    public UserAccount getUserDetail(@PathVariable Long id) {
        return accountService.findById(id).get();
    }
}
