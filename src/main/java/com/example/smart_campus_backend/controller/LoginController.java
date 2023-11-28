package com.example.smart_campus_backend.controller;


import com.example.smart_campus_backend.entity.users;
import com.example.smart_campus_backend.service.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServletRequest;


@org.springframework.stereotype.Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());
    @Autowired
    private LoginService LoginService;

    @CrossOrigin
    @RequestMapping("Login")
    @ResponseBody
    public users Login(HttpServletRequest request) {
        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");
        users user = LoginService.Login(account, pwd);
        if (user == null) {
            logger.warn("Login failed! "+"account:" + account +";pwd:" + pwd);
            return null;
        }
        logger.info("Some body login success! "+"account:" + account +";pwd:" + pwd);
        return user;
    }

    @Configuration
    public class CorsFilter {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")
                            .allowedOrigins("*")
                            .allowedMethods("*")
                            .allowedHeaders("*");
                }
            };
        }
    }
}
