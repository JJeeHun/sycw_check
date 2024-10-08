package com.sycw.sycw_check.api;

import com.sycw.sycw_check.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.RequestMatcherProvider;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Controller
@RequiredArgsConstructor
public class ApiViews {

    private final OrderApiRepository orderApiRepository;

    @GetMapping("/order/view")
    public String orderView(@RequestParam(required = false) LocalDate date, Model model) {
        if(date != null) {
            List<Order> orderAll = orderApiRepository.findOrderAll(date);
            model.addAttribute("orders", orderAll);
            model.addAttribute("defaultDate", date);
        }else {
            model.addAttribute("defaultDate", LocalDate.now());
            model.addAttribute("orders", new ArrayList<>());
        }
        return "order_view/order_list";
    }
}
