package com.romz.pma.controllers;

import com.romz.pma.dao.IUserAccount;
import com.romz.pma.entities.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author roman - Project project-management
 */
@Controller
public class SecurityController {

    IUserAccount accountRepo;

    @GetMapping("/register")
    public String register(Model model) {
        UserAccount userAccount = new UserAccount();

        model.addAttribute("userAccount", userAccount);

        return "register";
    }

    @PostMapping("/register/save")
    public void save(Model model) {

    }
}
