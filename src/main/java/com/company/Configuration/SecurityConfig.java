package com.company.Configuration;

import com.company.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeRequests().antMatchers("/login", "logout", "/", "/all_housings",
                "/find_housing_by_type", "/find_housing_by_price", "/find_housing_by_square",
                "/find_housing_by_number_of_rooms", "/find_housing_by_nearest_metro",
                "/find_housing_by_number_of_rooms_and_price", "/find_housing_by_nearest_metro_and_type",
                "/find_housing_by_nearest_metro_and_price", "/find_housing_by_nearest_metro_and_square",
                "/find_housing_by_nearest_metro_and_number_of_rooms",
                "/find_housing_by_nearest_metro_and_type_and_square", "/find_by_type", "/find_by_price",
                "/find_by_square", "/find_by_number_of_rooms", "/find_by_nearest_metro",
                "/find_by_number_of_rooms_and_price", "/find_by_nearest_metro_and_type",
                "/find_by_nearest_metro_and_price", "/find_by_nearest_metro_and_square",
                "/find_by_nearest_metro_and_number_of_rooms", "/find_by_nearest_metro_and_type_and_square",
                "/housing/{id}")
                .permitAll().anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/all_housing")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(encoder);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return  new BCryptPasswordEncoder();
    }
}
