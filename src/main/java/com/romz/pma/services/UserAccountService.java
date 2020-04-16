package com.romz.pma.services;
import com.romz.pma.dao.IUserAccount;
import com.romz.pma.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author roman - Project project-management
 */
@Service
public class UserAccountService {

    @Autowired
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


    public String login(String username, String password) {
        Optional<UserAccount> user = accountRepo.login(username, password);
        if (user.isPresent()) {
            String token = UUID.randomUUID().toString();
            UserAccount userAccount = user.get();
            userAccount.setToken(token);
            accountRepo.save(userAccount);

            return token;
        }

        return "";
    }

    public Optional<User> findByToken(String token) {
        Optional<UserAccount> userAccount = accountRepo.findByToken(token);
        if (userAccount.isPresent()) {
            UserAccount userAccount1 = userAccount.get();
            User authUser = new User(userAccount1.getUserName(), userAccount1.getPassword(), true, true, true, true,
                                     AuthorityUtils.createAuthorityList("ADMIN"));

            return Optional.of(authUser);
        }

        return Optional.empty();
    }

    public Optional<UserAccount> findById(Long id) {
        return accountRepo.findById(id);
    }
}
