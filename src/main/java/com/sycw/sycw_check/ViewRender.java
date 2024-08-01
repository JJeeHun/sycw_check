package com.sycw.sycw_check;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewRender {
    @GetMapping("/home")
    public String homeView() {
        return "home";
    }
}
