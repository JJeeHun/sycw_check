package com.sycw.sycw_check.si;

import com.sycw.sycw_check.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/si")
public class SiController {

    private final SiRepository siRepository;

    @GetMapping("/find-contact/{contactOrderNo}")
    public String findSystemOrderNo(@PathVariable String contactOrderNo, Model model) {

        List<OrderItemEntity> orderItem = siRepository.findOrderItem(contactOrderNo);
        List<ShippingEntity> shipping = siRepository.findShipping(contactOrderNo);
        List<PickingPlanEntity> plan = siRepository.findPlan(contactOrderNo);
        List<PickingEntity> picking = siRepository.findPicking(contactOrderNo);
        List<ClosingEntity> closing = siRepository.findClosing(contactOrderNo);

        model.addAttribute("orderItem",orderItem);
        model.addAttribute("shipping",shipping);
        model.addAttribute("plan",plan);
        model.addAttribute("picking",picking);
        model.addAttribute("closing",closing);

        return "contact_si";
    }
}
