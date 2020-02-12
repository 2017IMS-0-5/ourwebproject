package com.example.webproject.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//注销
@Controller
@RequestMapping("/sessionout")
public class LogoutSession{
    @GetMapping("/adminout")
    public String logout1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //false代表：不创建session对象，只是从request中获取。
        HttpSession session = request.getSession(false);
        if(session.getAttribute("admin") == null){
            return "redirect:/login";
        }
        session.removeAttribute("admin");
        return "redirect:/login";
    }
    @GetMapping("/userout")
    public String logout2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //false代表：不创建session对象，只是从request中获取。
        HttpSession session = request.getSession(false);
        if(session.getAttribute("user") == null){
            return "redirect:/login";
        }
        session.removeAttribute("user");
        return "redirect:/login";
    }

}
