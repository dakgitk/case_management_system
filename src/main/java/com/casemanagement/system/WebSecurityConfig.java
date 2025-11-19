package com.casemanagement.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

  private UserDetailsService userDetailsService;

  public WebSecurityConfig(UserDetailsService userDetailsService) {

    this.userDetailsService = userDetailsService;

  }

  

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(authoriz -> authoriz.anyRequest().authenticated())
        .formLogin(formLogin -> formLogin.loginPage("/login").defaultSuccessUrl("/caselist", true).permitAll())
        .logout(logout -> logout.permitAll());

    // http.authorizeHttpRequests(authoriz -> authoriz.anyRequest().authenticated())
    // .formLogin(form -> form.defaultSuccessUrl("/caselist",
    // true).permitAll()).logout(logout -> logout.permitAll());
    // ;

    return http.build();
  }

  // in memory users for testing
  // @Bean
  // public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
  //   UserDetails user = User.builder()
  //       .username("user")
  //       .password(passwordEncoder.encode("password")) // Use PasswordEncoder to encode the password
  //       .roles("USER")
  //       .build();

  //   UserDetails Alex = User.builder()
  //       .username("Alex")
  //       .password(passwordEncoder.encode("123")) // Use PasswordEncoder to encode the password
  //       .roles("USER")
  //       .build();

  //   UserDetails Admin = User.builder()
  //       .username("Admin")
  //       .password(passwordEncoder.encode("123")) // Use PasswordEncoder to encode the password
  //       .authorities("ADMIN")
  //       .build();

  //   List<UserDetails> users = new ArrayList<>();
  //   users.add(user);
  //   users.add(Alex);
  //   users.add(Admin);

  //   return new InMemoryUserDetailsManager(users);
  // }


  // @Autowired
  //   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
  //       auth
  //           .userDetailsService(userDetailsService)
  //           .passwordEncoder(passwordEncoder());
  //   }


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(); // Use BCryptPasswordEncoder for password encoding
  }

}
