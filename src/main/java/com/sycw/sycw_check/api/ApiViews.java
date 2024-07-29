package com.sycw.sycw_check.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiViews {

    @GetMapping("/order/view")
    public String orderView() {
        return "order_view/order_list";
    }
}
