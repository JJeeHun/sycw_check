package com.sycw.sycw_check.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.PrintWriter;

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

    @GetMapping("/contactCheck")
    public String contactCheckView() {
        return "contactCheck";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, @RequestParam String id, @RequestParam String password) {
        String clientUrl = request.getRemoteAddr();

        if ( (systemAdminID.equals(id) && systemAdminPW.equals(password))
            || clientUrl.equals("0:0:0:0:0:0:0:1") || clientUrl.startsWith("192.")
        ) {
            HttpSession session = request.getSession();
            session.setAttribute("id", "test");
            return "redirect:/contactCheck";
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
        String url = request.getRequestURL().toString();
        log.debug("Session Ok = {}",session != null);
        log.debug("Url => {}", url);
        if(session == null) response.sendRedirect("/");
        return session != null;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        if (ex != null) {
            try (PrintWriter writer = response.getWriter()) {
                writer.println(ex.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            }
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginController())
                .excludePathPatterns(
                    "/",
                    "/login",
                    "/css/**",
                    "/images/**",
                    "/static/js/**"
                );
    }
}
