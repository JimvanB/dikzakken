package com.jim.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jim on 29-11-17.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Jim").password("jim").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("Mireille").password("dikkie").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/authenticate")
                .permitAll()
            .and()
            .logout();
           // .logoutSuccessUrl("/loginForm");
        // http.authorizeRequests().anyRequest().not().authenticated().mvcMatchers("/registratie");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/img/**");
        web.ignoring().antMatchers("/styles/**");
        web.ignoring().antMatchers("/node_modules/**");
        web.ignoring().antMatchers("/registratieForm");
        web.ignoring().antMatchers("/registratie");
    }
}
