package com.sycw.sycw_check.asn;

import com.sycw.sycw_check.entity.ASNHeaderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/asn")
public class AsnHeaderController {

    private final AsnHeaderRepository repository;
    private final String sp = System.lineSeparator();

    @GetMapping("/header/search")
    public String header(Model model) {
        model.addAttribute("asnHeaders", repository.selectNotCompleteList());
        model.addAttribute("customer", repository.selectAsnCustomer());

        return "order_view/asn_header_status_update";
    }

    @PatchMapping("/header")
    @Transactional
    public ResponseEntity<String> state20Update(
            @RequestBody(required = false) List<ASNHeaderEntity> headerEntityList
    ) {
        if( headerEntityList.isEmpty() ) {
            return ResponseEntity.badRequest().body("저장 할 데이터가 없습니다.");
        }

        headerEntityList
            .forEach(header -> {
                int result = repository.updateState20(
                        header.getInterfaceId(),
                        header.getFunctionCode(),
                        header.getSiNo(),
                        header.getShipmentItemNo()
                );
                if(result != 1) throw new RuntimeException("수정에 실패했습니다. ex) " + errorInfo(header));
            });

        return ResponseEntity.ok("Success");
    }

    private String errorInfo(ASNHeaderEntity entity) {

        return String.format("[%s Si No = %s,%s Interface Id = %s,%s Function Code = %s,%s Bol No = %s%s]",
                sp,
                entity.getSiNo(),
                sp,
                entity.getInterfaceId(),
                sp,
                entity.getFunctionCode(),
                sp,
                entity.getBolNo(),
                sp
        );
    }

}
