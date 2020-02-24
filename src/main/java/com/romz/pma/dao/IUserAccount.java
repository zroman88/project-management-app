package com.romz.pma.dao;

import com.romz.pma.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * @author roman - Project project-management
 */
public interface IUserAccount extends CrudRepository<UserAccount, Long> {
}
