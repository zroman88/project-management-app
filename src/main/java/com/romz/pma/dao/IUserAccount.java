package com.romz.pma.dao;

import com.romz.pma.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author roman - Project project-management
 */
public interface IUserAccount extends CrudRepository<UserAccount, Long> {
    @Override
    List<UserAccount> findAll();
}
