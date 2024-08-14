package com.sycw.sycw_check.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class PickingEntity {

  private String pickingNo;
  private LocalDateTime pickingDate;
  private String pickingRule;
  private String packingNo;
  private String zoneNo;
  private String productNo;
  private String oordNo;
  private String systemOrderNo;
  private String packingType;
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
  private double pickingQty;
  private String skuType;
  private double skuUnitQty;
  private double denominatorQty;
  private double skuPickingQty;
  private String palletNo;
  private String oordItemNo;
  private String orderItemNo;
  private String contactOrdNo;
  private String contactOrdType;
  private String waveNo;
  private String waveItemNo;
  private String siNo;
  private String siItemNo;
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
  private String trackingNo;
  private String pickingPlanNo;

}
