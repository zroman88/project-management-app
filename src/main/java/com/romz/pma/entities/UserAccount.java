package com.romz.pma.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * @author roman - Project project-management
 */
@Entity
@Data
@RequiredArgsConstructor
@Table(name = "user_accounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_accounts_seq")
    @SequenceGenerator(name = "user_accounts_seq", sequenceName = "user_accounts_seq", allocationSize = 1, initialValue = 1)
    private long userId;

    @Column(name = "username")
    private String userName;

    private String email;

    private String password;

    private String role;

    private boolean enabled = true;
}
