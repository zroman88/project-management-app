package com.romz.pma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.sql.DataSource;

/**
 * @author Roman - Project project-management
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    BCryptPasswordEncoder encoder;

    private static final RequestMatcher PROTECTED_URLS = new OrRequestMatcher(new AntPathRequestMatcher("/app-api/**"));

    AuthenticationProvider provider;

    public SecurityConfiguration(final AuthenticationProvider provider) {
        super();
        this.provider = provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//            .usersByUsernameQuery("SELECT username, password, enabled FROM user_accounts WHERE username=?")
//            .authoritiesByUsernameQuery("SELECT username, role FROM user_accounts WHERE username=?")
//            .dataSource(dataSource)
//            .passwordEncoder(encoder);
        auth.authenticationProvider(provider);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/token/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable() // This is for the REST API to work properly
//            .authorizeRequests().anyRequest().authenticated()
////            .antMatchers("/projects/new").hasRole("ADMIN")
////            .antMatchers("/projects/save").hasRole("ADMIN")
////            .antMatchers("/employees/new").hasRole("ADMIN")
////            .antMatchers("/employees/save").hasRole("ADMIN")
////            .antMatchers("/", "/**").permitAll()
//            .and()
//            .httpBasic();
    http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .exceptionHandling().and()
        .authenticationProvider(provider)
        .addFilterBefore(authenticationFilter(), AnonymousAuthenticationFilter.class)
        .authorizeRequests().requestMatchers(PROTECTED_URLS)
        .authenticated().and().csrf().disable()
        .formLogin().disable()
        .httpBasic().disable()
        .logout().disable();

    }

    private AuthenticationFilter authenticationFilter() throws Exception{
        final AuthenticationFilter filter = new AuthenticationFilter(PROTECTED_URLS);
        filter.setAuthenticationManager(authenticationManager());

        return filter;
    }

    @Bean
    AuthenticationEntryPoint forbiddenEntryPoint() {
        return new HttpStatusEntryPoint(HttpStatus.FORBIDDEN);
    }
}
