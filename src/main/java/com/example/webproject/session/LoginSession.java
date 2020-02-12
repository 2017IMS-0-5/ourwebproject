package com.example.webproject.session;

import com.example.webproject.entity.Admin;
import com.example.webproject.entity.User;
import com.example.webproject.service.AdminService;
import com.example.webproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/sessionin")
public class LoginSession{//Session存着用户信息

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "account", required = true) String account,
                        @RequestParam(value = "password", required = true) String password,
                        @RequestParam(value = "role", required = true) String role
    ) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){
            return "redirect:/main";
        }

        if(session.getAttribute("admin")!=null){
            return "redirect:/admin/generalShow";
        }

        if(role.equals("user")) {
            List<User> list = userService.listUsers();
            for (User user : list) {
                if (user.getAccount().equals(account) && user.getPassword().equals(password)) {
                    request.getSession().setAttribute("user", user);
                    return "redirect:/main";
                }
            }
            System.out.println("登录失败：用户名或密码错误");
            return "redirect:/login";
        }
        else{
            List<Admin> list = adminService.listAdmins();
            for (Admin admin : list) {
                if (admin.getAccount().equals(account) && admin.getPassword().equals(password)) {
                    request.getSession().setAttribute("admin", admin);
                    return "redirect:/admin/homepage";
                }
            }
            System.out.println("登录失败：用户名或密码错误");
            return "redirect:/login";
        }
    }
}

