package com.romz.pma.services;
import com.romz.pma.dao.IUserAccount;
import com.romz.pma.entities.UserAccount;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author roman - Project project-management
 */
@Service
public class UserAccountService {

    private IUserAccount accountRepo;

    public UserAccountService(IUserAccount accountRepo) {
        this.accountRepo = accountRepo;
    }

    public List<UserAccount> findAll() {
        return accountRepo.findAll();
    }

    public void save(UserAccount userAccount) {
        accountRepo.save(userAccount);
    }
}
