package com.romz.pma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * @author Roman - Project project-management
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .withDefaultSchema()
            .passwordEncoder(getPasswordEnc())
            .withUser("myuser")
            .password("pass")
            .roles("USER")
            .and()
            .withUser("roman")
            .password("pass")
            .roles("USER")
            .and()
            .withUser("manager")
            .password(getPasswordEnc().encode("pass"))
            .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEnc() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/projects/new").hasRole("ADMIN")
            .antMatchers("/projects/save").hasRole("ADMIN")
            .antMatchers("/h2_console/**").permitAll()
            .antMatchers("/").authenticated().and().formLogin();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
