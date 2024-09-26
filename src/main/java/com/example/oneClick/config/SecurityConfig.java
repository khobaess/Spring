package com.example.oneClick.config;

import com.example.oneClick.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final PersonDetailsService personDetailsService;
    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/catalog", "/champagnes", "/energetics", "/lowalcohols", "/strongalcohols", "/wines", "/champagne/**",  "/energetic/**",  "/lowalcohol/**",  "/strongalcohol/**",  "/wine/**", "/cart", "/auth/registration", "/product_edit", "/product_edit/**}").permitAll()
                .and()
                .formLogin().loginPage("/auth/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/catalog")
                .failureUrl("/auth/login?error")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/auth/login");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsService);
    }

    @EnableWebSecurity
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {


        private final PersonDetailsService personDetailsService;
        @Autowired
        public SecurityConfig(PersonDetailsService personDetailsService) {
            this.personDetailsService = personDetailsService;
        }


        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.authorizeRequests()
                    .antMatchers("/catalog", "/champagnes", "/energetics", "/lowalcohols",
                            "/strongalcohols", "/wines", "/champagne/**",  "/energetic/**",
                            "/lowalcohol/**",  "/strongalcohol/**",  "/wine/**", "/cart",
                            "/auth/registration", "/product_edit", "/product_edit/**}",
                            "/champagne_edit/", "/champagne_edit/").permitAll()
                    .and()
                    .formLogin().loginPage("/auth/login")
                    .loginProcessingUrl("/process_login")
                    .defaultSuccessUrl("/catalog")
                    .failureUrl("/auth/login?error")
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/auth/login");


        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(personDetailsService);
        }
    }
}
