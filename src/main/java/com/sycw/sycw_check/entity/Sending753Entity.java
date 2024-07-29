package com.sycw.sycw_check.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class Sending753Entity {

  private String siNo;
  private String detailItemNo;
  private String itemNo;
  private String contactOrdNo;
  private LocalDateTime pickupDate;
  private String poNo;
  private String itemUom;
  private double itemQty;
  private String weightUom;
  private double weight;
  private String volumeUom;
  private double volume;
  private String createUser;
  private LocalDateTime createDate;
  private String updateUser;
  private LocalDateTime updateDate;

}
