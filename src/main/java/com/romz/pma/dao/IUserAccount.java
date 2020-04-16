package com.romz.pma.dao;

import com.romz.pma.entities.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author roman - Project project-management
 */
@Repository
public interface IUserAccount extends CrudRepository<UserAccount, Long> {
    @Override
    List<UserAccount> findAll();

    @Query(value = "SELECT u FROM UserAccount u WHERE u.userName = ?1 and u.password = ?2 ")
    Optional<UserAccount> login(String username, String password);

    Optional<UserAccount> findByToken(String token);
}
