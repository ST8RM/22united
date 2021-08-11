package com.example.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.inMemoryAuthentication()
                   .withUser("ADMIN")
                   .password("admin")
                   .roles("ADMIN")
                    .and()
                   .withUser("user")
                   .password("user")
                   .roles("USER")
                    .and()
                   .withUser("READER")
                   .password("READER")
                   .roles("READER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()



                .antMatchers("/main").permitAll()

                .antMatchers("/market/add").hasAnyRole("ADMIN","READER")
                .antMatchers("//market/{id}/edit").hasAnyRole("ADMIN","READER")
                .antMatchers("//market/{id}/delete").hasAnyRole("ADMIN","READER")
                .antMatchers("/about").permitAll()
                .antMatchers("/market").permitAll()
                .and()
                .csrf().disable()
                .formLogin();

    }

    @Bean
    public PasswordEncoder encoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
