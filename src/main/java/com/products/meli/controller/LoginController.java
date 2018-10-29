package com.products.meli.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @GetMapping("/login")
    public void login (HttpServletResponse response) throws IOException {
        System.out.println("Login backend");
        response.sendRedirect("http://localhost:4200/admin");
    }

    @GetMapping("/logout")
    public void logout (HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Logout backend");
        HttpSession session= request.getSession();
        SecurityContextHolder.clearContext();
        if(session == null) {
            session.invalidate();
        }
        response.sendRedirect("https://www.mercadolibre.com/jms/mpe/lgz/logout?go=http://localhost:4200/login");
    }
}
