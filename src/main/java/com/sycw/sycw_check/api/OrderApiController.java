package com.sycw.sycw_check.api;

import com.sycw.sycw_check.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderApiController {

    private final OrderApiRepository orderApiRepository;

    @GetMapping("/{systemOrderNo}")
    public List<OrderItemEntity> getOrderItems(@PathVariable(name = "systemOrderNo") String systemOrderNo) {
        return orderApiRepository.findOrderItemAll(systemOrderNo);
    }

    @GetMapping("/{systemOrderNo}/{itemNo}")
    public Map<String,Object> getOrderRelationItems(@PathVariable String systemOrderNo, @PathVariable Long itemNo) {
        List<ShippingEntity> shippingAll = orderApiRepository.findShippingAll(systemOrderNo, itemNo);
//        List<PickingPlanEntity> pickingPlanAll = orderApiRepository.findPickingPlanAll(systemOrderNo, itemNo);
        List<PickingEntity> pickingAll = orderApiRepository.findPickingAll(systemOrderNo, itemNo);
        List<ClosingEntity> closingAll = orderApiRepository.findClosingAll(systemOrderNo, itemNo);

        return new HashMap<>() {{
            put("shipping", shippingAll);
//            put("plan", shippingAll);
            put("picking", pickingAll);
            put("close", closingAll);
        }};
    }

}
