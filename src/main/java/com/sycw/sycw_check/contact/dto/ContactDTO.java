package com.sycw.sycw_check.contact.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ContactDTO {

    private String contactOrderNo;
    private Long qty;

    public ContactDTO(String contactOrderNo) {
        this.contactOrderNo = contactOrderNo;
    }
}
