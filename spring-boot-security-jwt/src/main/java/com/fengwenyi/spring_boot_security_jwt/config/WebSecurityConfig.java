package com.fengwenyi.spring_boot_security_jwt.config;

import com.fengwenyi.spring_boot_security_jwt.filter.JwtAuthenticationTokenFilter;
import com.fengwenyi.spring_boot_security_jwt.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.Header;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/25
 */
@Configuration
@EnableWebSecurity
//添加annotation 支持,包括（prePostEnabled，securedEnabled...）
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private MyLogoutHandler myLogoutHandler;

    @Autowired
    private EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;

    @Autowired
    private RestAccessDeniedHandler restAccessDeniedHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                    .antMatchers("/static/**").permitAll() //静态资源访问无需认证
                    .antMatchers("/").permitAll() // 允许访问的接口
                    .antMatchers("/admin/**").hasAnyRole("ADMIN", "MANAGER") //admin开头的请求，需要admin权限
                    .antMatchers("/user/**").hasRole("USER") //需登陆才能访问的url
                    .anyRequest().authenticated()  //默认其它的请求都需要认证，这里一定要添加
                 .and()
                    .cors()  //支持跨域
                .and()   //添加header设置，支持跨域和ajax请求
                    .headers()
                        .addHeaderWriter(
                            new StaticHeadersWriter(Arrays.asList(
                                    new Header("Access-control-Allow-Origin","*"),
                                    new Header("Access-Control-Expose-Headers","Authorization"))))
                .and()
                    //指定登录界面，并且设置为所有人都能访问；
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/login")
                    .permitAll()
                    .successHandler(myAuthenticationSuccessHandler)
                    .failureHandler(myAuthenticationFailureHandler)
                .and()
                    //使用默认的logoutFilter
                    .logout()
                    .logoutUrl("/logout")   //默认就是"/logout"
                    .addLogoutHandler(myLogoutHandler)  //logout时清除token
                    .logoutSuccessHandler(myLogoutSuccessHandler) //logout成功后返回200
                .and()
                    // 处理异常情况：认证失败和权限不足
                    .exceptionHandling()
                        .authenticationEntryPoint(entryPointUnauthorizedHandler)
                        .accessDeniedHandler(restAccessDeniedHandler)
                .and()
                    .csrf()
                        .disable()
                    .sessionManagement()
                        .disable()
        ;
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                // 设置UserDetailsService
                .userDetailsService(this.userDetailsService)
                // 使用加密
                .passwordEncoder(passwordEncoder());
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
