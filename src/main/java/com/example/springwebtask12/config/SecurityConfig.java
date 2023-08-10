package com.example.springwebtask12.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}Secret_123").roles("ADMIN","CARS")
                .and()
                .withUser("admin2").password("{noop}Secret_123").authorities("ROLE_USER_ADMIN")
                .and()
                .withUser("admin3").password("{noop}Secret_123").roles("CARS");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .mvcMatchers(HttpMethod.GET, "/api/cars").hasAnyRole("ADMIN", "CARS")
//                .mvcMatchers(HttpMethod.POST,"/api/cars").authenticated()
//                .mvcMatchers("/api/cars/**").hasAuthority("ROLE_USER_ADMIN")
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .and()
//                .logout()
//                .and()
//                .mvcMatcher("/api").csrf().disable();
//    }
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/api/cars").hasAnyRole("ADMIN", "CARS")
                .mvcMatchers(HttpMethod.POST,"/api/cars").authenticated()
                .mvcMatchers("/api/cars/**").hasAuthority("ROLE_USER_ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .httpBasic()
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().ignoringAntMatchers("/api/**");
    }
}
