package com.romz.pma.controllers;

import com.romz.pma.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

/**
 * @author roman - Project project-management
 */
@RestController
public class TokenController {
    @Autowired
    UserAccountService accountService;

    @PostMapping("/token")
    public String getToken(@RequestParam("username") final String username, @RequestParam("password") final String password) {
        String token = accountService.login(username, password);
        if (StringUtils.isEmpty(token)) {
            return "no token found";
        }

        return token;
    }
}
