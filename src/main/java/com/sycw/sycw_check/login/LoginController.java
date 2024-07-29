package com.sycw.sycw_check.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@Slf4j
public class LoginController implements HandlerInterceptor, WebMvcConfigurer {

    private static final String systemAdminID = "safecnc";
    private static final String systemAdminPW = "safe7900";

    @GetMapping("/")
    public String loginPage(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) return "contactCheck";
        return "login";
    }


    @PostMapping("/login")
    public String login(HttpServletRequest request, @RequestParam String id, @RequestParam String password) {
        if (systemAdminID.equals(id) && systemAdminPW.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("id", "test");
            return "contactCheck";
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        log.debug("Session Ok = {}",session != null);
        if(session == null) response.sendRedirect("/");
        return session != null;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginController())
                .excludePathPatterns(
                        "/",
                        "/login",
                        "/css/**",
                        "/images/**",
                        "/js/**"
                );
    }
}