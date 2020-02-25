package com.romz.pma.controllers;

import com.romz.pma.entities.UserAccount;
import com.romz.pma.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author roman - Project project-management
 */
@Controller
public class SecurityController {
    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    UserAccountService accountService;

    @GetMapping("/register")
    public String register(Model model) {
        UserAccount userAccount = new UserAccount();

        model.addAttribute("userAccount", userAccount);

        return "/security/register";
    }

    @PostMapping("/register/save")
    public String save(Model model, UserAccount userAccount) {

        userAccount.setPassword(encoder.encode(userAccount.getPassword()));
        accountService.save(userAccount);

        return "redirect:/";
    }
}
