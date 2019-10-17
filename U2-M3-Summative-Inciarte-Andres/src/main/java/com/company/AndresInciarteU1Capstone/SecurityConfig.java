package com.company.AndresInciarteU1Capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
// Web security is enabled
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void ConfigAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        //we hash the passwords in this database using a PasswordEncoder.
        //This will cause Spring Security to apply the BCrypt hashing algorithm to incoming passwords
        // before comparing them to the value in the database.
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        //AuthenticationManagerBuilder configures Spring Security to use the database schema.
        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username = ?")
                .passwordEncoder(encoder);

    }

    public void configure(HttpSecurity httpSecurity) throws Exception {

        //Turn on HTTP Basic Authentication
        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
                .mvcMatchers(HttpMethod.POST, "/console").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.GET, "/console").permitAll()
                .mvcMatchers(HttpMethod.GET,"/console/find/*").permitAll()
                .mvcMatchers(HttpMethod.PUT,"/console/update/*").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.DELETE, "/console/delete/*").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET,"/console/findbymanufacturer/*").permitAll()
                .anyRequest().permitAll();

        httpSecurity.authorizeRequests()
                .mvcMatchers(HttpMethod.GET,"/game").permitAll()
                .mvcMatchers(HttpMethod.POST,"/game").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.GET,"/game/find/*").permitAll()
                .mvcMatchers(HttpMethod.PUT,"game/update/*").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.DELETE,"game/delete/*").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET,"game/findbystudio/*").permitAll()
                .mvcMatchers(HttpMethod.GET,"game/findbyesrb/*").permitAll()
                .mvcMatchers(HttpMethod.GET,"game/findbytitle/*").permitAll()
                .anyRequest().permitAll();

        httpSecurity.authorizeRequests()
                .mvcMatchers(HttpMethod.GET,"/tshirt").permitAll()
                .mvcMatchers(HttpMethod.POST,"/tshirt").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.GET,"/tshirt/find/*").permitAll()
                .mvcMatchers(HttpMethod.PUT,"/tshirt/update/*").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.DELETE,"/tshirt/delete/*").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET,"/tshirt/findbycolor/*").permitAll()
                .mvcMatchers(HttpMethod.GET,"/tshirt/findbysize/*").permitAll()
                .anyRequest().permitAll();


        httpSecurity
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    }
}
