package com.sycw.sycw_check.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class ShippingEntity {

  private LocalDateTime etd;
  private String siNo;
  private String siItemNo;
  private String systemOrderNo;
  private String oordNo;
  private String itemNo;
  private String contactOrdNo;
  private String contactOrdType;
  private String waveNo;
  private String productNo;
  private double plannedQty;
  private double skuSiQty;
  private String createUser;
  private LocalDateTime createDate;
  private String updateUser;
  private LocalDateTime updateDate;

}
