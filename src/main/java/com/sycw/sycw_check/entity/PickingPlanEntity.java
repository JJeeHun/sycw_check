package com.sycw.sycw_check.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class PickingPlanEntity {

  private String pickingPlanNo;
  private LocalDateTime pickingPlanDate;
  private String pickingRule;
  private String zoneNo;
  private String contactOrdNo;
  private String productNo;
  private String planTime;
  private LocalDateTime etd;
  private LocalDateTime previousProcessDate;
  private LocalDateTime dueDate;
  private LocalDateTime ordReceiptDate;
  private String customerNo;
  private String destinationNo;
  private String supplierNo;
  private String shippingDocumentNo;
  private String lotNo;
  private String poNo;
  private String poItemNo;
  private String locationNo;
  private double orderQty;
  private double pendingQty;
  private double piPlanQty;
  private String skuType;
  private double skuUnitQty;
  private double denominatorQty;
  private double skuPwQty;
  private String palletNo;
  private String siNo;
  private String siItemNo;
  private String oordNo;
  private String oordItemNo;
  private String orderItemNo;
  private String invenOwnership;
  private String centerNo;
  private LocalDateTime productionDate;
  private LocalDateTime expiryDate;
  private String remark;
  private String isBlocked;
  private LocalDateTime blockedDate;
  private String blockedBy;
  private String blockedReason;
  private String blockedMode;
  private String edoc;
  private String shippingDocNo;
  private String truckOrderNo;
  private String truckNo;
  private String truckType;
  private String invenNo;
  private String createUser;
  private LocalDateTime createDate;
  private String updateUser;
  private LocalDateTime updateDate;

}
