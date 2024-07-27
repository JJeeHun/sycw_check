package com.sycw.sycw_check.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class ClosingEntity {

  private LocalDateTime inspDate;
  private String inspNo;
  private String systemOrderNo;
  private String oordNo;
  private String contactOrdNo;
  private String contactOrdType;
  private String productNo;
  private String productName;
  private String barcode;
  private String giNo;
  private LocalDateTime etd;
  private LocalDateTime dueDate;
  private LocalDateTime ordReceiptDate;
  private LocalDateTime closingDate;
  private LocalDateTime giDate;
  private String packingNo;
  private String packingType;
  private long packingSeq;
  private String boxNo;
  private String customerNo;
  private String destinationNo;
  private String supplierNo;
  private String shippingDocumentNo;
  private double qty;
  private String lotNo;
  private LocalDateTime productionDate;
  private LocalDateTime expiryDate;
  private String siNo;
  private String siItemNo;
  private String poNo;
  private String poItemNo;
  private String locationNo;
  private double pendingQty;
  private double pwQty;
  private String skuNo;
  private String skuDesc;
  private String skuType;
  private double skuUnitQty;
  private String grNo;
  private String uom;
  private double denominatorQty;
  private double skuPwQty;
  private String zoneNo;
  private String palletNo;
  private String oordItemNo;
  private String remark;
  private String isBlocked;
  private LocalDateTime blockedDate;
  private String blockedBy;
  private String blockedReason;
  private String blockedMode;
  private String waveNo;
  private String trackNo;
  private String createUser;
  private LocalDateTime createDate;
  private String updateUser;
  private LocalDateTime updateDate;

}
