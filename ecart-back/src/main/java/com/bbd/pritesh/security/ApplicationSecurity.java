package com.bbd.pritesh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bbd.pritesh.jwt.AuthTokenFilter;
import com.bbd.pritesh.service.impl.UserServiceImpl;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class ApplicationSecurity  extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userDetailsService;
    
    @Autowired
    private PasswordEncoder encoder;
    
    @Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

    
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                                   "/configuration/ui",
                                   "/swagger-resources/**",
                                   "/configuration/security",
                                   "/swagger-ui.html",
                                   "/webjars/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/user/login", "/user/save", "/product/getbytype/{type}", "/product/getall","/productcategory/getall","/user/generate/{email}","/user/generateotp/{email}","/user/updatepassword").permitAll()
                .antMatchers("/product/save", "/product/update","/order/getall","/product/deleteone","/user/getall").hasAuthority("admin")//hasAuthority("admin")
                .antMatchers("/user/update","/user/updatepassword","/address/update","/address/save","/productrating/save").hasAuthority("user")
                .anyRequest().authenticated()
                .and()
		        .exceptionHandling()
		        .authenticationEntryPoint(authenticationEntryPoint)
                .and().
                addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
