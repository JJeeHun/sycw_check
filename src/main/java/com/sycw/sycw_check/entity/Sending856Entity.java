package com.sycw.sycw_check.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class Sending856Entity {

  private long seq;
  private String siNo;
  private String poNo;
  private LocalDateTime orderDate;
  private String contactOrdNo;
  private String poOrderType;
  private double pkgQty;
  private String invoiceNo;
  private String departmentNo;
  private String soldToName;
  private String soldToNo;
  private String vendorCd;
  private double tareSscc;
  private double packageGrossWeight;
  private String packageCarrierMethod;
  private String packageTrackingNo;
  private String packageSscc;
  private String packageLineNo;
  private String packageProductNo;
  private String packageProductName;
  private double packageQty;
  private double packageOrderQty;
  private String packageServiceLevel;
  private String packagePalletNo;
  private String itemNo;
  private String itemLineNo;
  private String itemProductNo;
  private String itemProductName;
  private String itemPoItemNo;
  private String itemOriginCountry;
  private String itemLotNo;
  private double itemQty;
  private double itemOrderQty;
  private String itemWarehouseNo;
  private double itemGrossWeight;
  private String itemCarrierMethod;
  private String itemTrackingNo;
  private String itemSscc;
  private String itemCustomerProductNo;
  private String itemServiceLevel;
  private String packingNo;
  private String packingBoxCd;
  private String systemOrderNo;
  private String createUser;
  private LocalDateTime createDate;
  private String updateUser;
  private LocalDateTime updateDate;
  private String cowaynDate;

}
