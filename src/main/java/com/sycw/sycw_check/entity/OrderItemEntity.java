package com.sycw.sycw_check.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class OrderItemEntity {

  private String systemOrderNo;
  private long itemNo;
  private String itemLineNo;
  private String itemCd;
  private String itemUpc;
  private String itemNm;
  private String mchntItemCd;
  private String omsItemCd;
  private String itemLvl;
  private Long itemQty;
  private String itemSerial;
  private String itemShipQty;
  private String unitPrice;
  private String taxRate;
  private String taxAmt;
  private String subTotAmt;
  private String mfgId;
  private String gtinNo;
  private String skuDesc;
  private String invoiceNo;
  private String invoiceItemNo;
  private String poNo;
  private String poItemNo;
  private String zoneNo;
  private String locationNo;
  private String lotNo;
  private String itemRemark;
  private String itemNote;
  private LocalDateTime productionDate;
  private LocalDateTime expiryDate;
  private String productState;
  private String skuQty;
  private String createUser;
  private LocalDateTime createDate;
  private String updateUser;
  private LocalDateTime updateDate;

}
