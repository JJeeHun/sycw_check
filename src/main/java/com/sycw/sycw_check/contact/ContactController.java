package com.sycw.sycw_check.contact;

import com.sycw.sycw_check.contact.dto.ContactDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController {

    private final ContactRepository contactRepository;

    private List<Map<String, Map<String, List<ContactDTO>>>> contactQtyService(List<ContactDTO> contactOrderList) {
        List<String> contactOrderNos = contactOrderList.stream()
                .map(ContactDTO::getContactOrderNo)
                .toList();

        Map<String,List<ContactDTO>> originalQty = getContactGroup(contactOrderList);
        Map<String,List<ContactDTO>> orderQty = getContactGroup(contactRepository.orderQty(contactOrderNos));
        Map<String,List<ContactDTO>> giQty = getContactGroup(contactRepository.giQty(contactOrderNos));
        Map<String,List<ContactDTO>> shippingInstructionQty = getContactGroup(contactRepository.shippingInstructionQty(contactOrderNos));
        Map<String,List<ContactDTO>> pickingPlanQty = getContactGroup(contactRepository.pickingPlanQty(contactOrderNos));
        Map<String,List<ContactDTO>> pickingQty = getContactGroup(contactRepository.pickingQty(contactOrderNos));
        Map<String,List<ContactDTO>> giClosingQty = getContactGroup(contactRepository.giClosingQty(contactOrderNos));
        Map<String,List<ContactDTO>> sending753 = getContactGroup(contactRepository.sending753d(contactOrderNos));
        Map<String,List<ContactDTO>> sending856 = getContactGroup(contactRepository.sending856d(contactOrderNos));

        return contactOrderNos.stream()
                .map(contactOrderNo -> {
                    Map<String, Map<String, List<ContactDTO>>> contact = new HashMap<>();
                    Map<String, List<ContactDTO>> stringListHashMap = new HashMap<>(){{
                        put("original", originalQty.get(contactOrderNo));
                        put("order", orderQty.get(contactOrderNo));
                        put("gi", giQty.get(contactOrderNo));
                        put("shipping", shippingInstructionQty.get(contactOrderNo));
                        put("plan", pickingPlanQty.get(contactOrderNo));
                        put("picking", pickingQty.get(contactOrderNo));
                        put("closing", giClosingQty.get(contactOrderNo));
                        put("sending753", sending753.get(contactOrderNo));
                        put("sending856", sending856.get(contactOrderNo));
                    }};

                    contact.put(contactOrderNo, stringListHashMap);
                    return contact;
                })
                .collect(Collectors.toList());
    }

    private Map<String, List<ContactDTO>> getContactGroup(List<ContactDTO> list) {
        return list.stream().collect(Collectors.groupingBy(ContactDTO::getContactOrderNo));
    }

    @PostMapping("/check-qty")
    @Transactional
    public String checkQty(String contactOrderNo, MultipartFile file, Model model) {

        if(contactOrderNo == null && (file == null || file.isEmpty()) ) return "redirect:/contactCheck.html";

        if(!file.isEmpty()) {
            List<ContactDTO> contactList = getCsv(file);

            List<Map<String, Map<String, List<ContactDTO>>>> maps = this.contactQtyService(contactList);
            model.addAttribute("jsData", maps);
        }else {
            assert contactOrderNo != null;
            String[] split = contactOrderNo.split(System.lineSeparator());
            List<ContactDTO> contactDTOS = Arrays.stream(split)
                    .map(ContactDTO::new)
                    .toList();

            List<Map<String, Map<String, List<ContactDTO>>>> maps = this.contactQtyService(contactDTOS);
            model.addAttribute("isCheckOrder", true);
            model.addAttribute("jsData", maps);
        }

        return "contactResult";
    }

    @GetMapping("/contact-check")
    public String contactView() {
        return "contactCheck";
    }


    private List<ContactDTO> getCsv(MultipartFile file) {
        List<ContactDTO> contactList = new ArrayList<>();
        boolean isSuccessKeyProps = false;
        final String keyCheckContact = "Contact Order No";
        final String keyCheckQty = "Qty";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                if(!isSuccessKeyProps) {
                    if (!(keyCheckContact.equals(fields[0]) && keyCheckQty.equals(fields[1]))) {
                        throw new RuntimeException("Key가 안맞습니다.");
                    }
                    isSuccessKeyProps = true;
                }else {
                    ContactDTO contact = new ContactDTO();

                    contact.setContactOrderNo(fields[0]);
                    contact.setQty(Long.valueOf(fields[1]));

                    contactList.add(contact);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contactList;
    }
}
