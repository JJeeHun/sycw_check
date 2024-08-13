package com.sycw.sycw_check.si;

import com.sycw.sycw_check.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/si")
@Transactional
public class SiController {

    private final SiOrderRepository siOrderRepository;
    private final SiRepository siRepository;


    @GetMapping
    public String siView(@RequestParam(required = false) LocalDate date, Model model) {
        if(date != null) {
            List<Map<String, Object>> siNoList = siRepository.findSiNoList(date);
            List<String> searchSiNoList = siNoList.stream()
                    .map(si -> (String) si.get("siNo"))
                    .toList();

            if(searchSiNoList.isEmpty()) searchSiNoList = List.of("");

            List<ShippingEntity> shippingAll = siRepository.findShippingAll(searchSiNoList);
            List<PickingPlanEntity> planAll = siRepository.findPlanAll(searchSiNoList);
            List<PickingEntity> pickingAll = siRepository.findPickingAll(searchSiNoList);
            List<ClosingEntity> closingAll = siRepository.findClosingAll(searchSiNoList);
            List<Sending753Entity> sending753All = siRepository.findSending753All(searchSiNoList);
            List<Sending856Entity> sending856All = siRepository.findSending856All(searchSiNoList);

            model.addAttribute("defaultDate", date);
            model.addAttribute("siList", siNoList);
            model.addAttribute("shipping", shippingAll);
            model.addAttribute("plan", planAll);
            model.addAttribute("picking", pickingAll);
            model.addAttribute("closing", closingAll);
            model.addAttribute("sending753", sending753All);
            model.addAttribute("sending856", sending856All);
        }else {
            model.addAttribute("defaultDate", LocalDate.now());
            model.addAttribute("siList", new ArrayList<>());
            model.addAttribute("shipping", new ArrayList<>());
            model.addAttribute("plan", new ArrayList<>());
            model.addAttribute("picking", new ArrayList<>());
            model.addAttribute("closing", new ArrayList<>());
            model.addAttribute("sending753", new ArrayList<>());
            model.addAttribute("sending856", new ArrayList<>());
        }
        return "order_view/si_list";
    }

    @GetMapping("/find-contact/{contactOrderNo}")
    public String findSystemOrderNo(@PathVariable String contactOrderNo, Model model) {

        List<OrderItemEntity> orderItem = siOrderRepository.findOrderItem(contactOrderNo);
        List<ShippingEntity> shipping = siOrderRepository.findShipping(contactOrderNo);
        List<PickingPlanEntity> plan = siOrderRepository.findPlan(contactOrderNo);
        List<PickingEntity> picking = siOrderRepository.findPicking(contactOrderNo);
        List<ClosingEntity> closing = siOrderRepository.findClosing(contactOrderNo);
        List<Sending753Entity> sending753 = siOrderRepository.findSending753(contactOrderNo);
        List<Sending856Entity> sending856 = siOrderRepository.findSending856(contactOrderNo);

        model.addAttribute("orderItem", orderItem);
        model.addAttribute("shipping", shipping);
        model.addAttribute("plan", plan);
        model.addAttribute("picking", picking);
        model.addAttribute("closing", closing);
        model.addAttribute("sending753", sending753);
        model.addAttribute("sending856", sending856);

        return "contact_si";
    }
}
