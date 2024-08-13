package com.sycw.sycw_check.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class ASNHeaderEntity {

  private String interfaceId;
  private String functionCode;
  private String siNo;
  private String receiverId;
  private String createDate;
  private String createTime;
  private String shipmentItemNo;
  private String hierarchicalLevel;
  private String pkgQty;
  private String weight;
  private String volume;
  private String scac;
  private String carrierName;
  private String trailerNo;
  private String bolNo;
  private String proNo;
  private String sealNo;
  private String loadNo;
  private String appointmentNo;
  private String contactPerson;
  private String contactTel;
  private String shipDate;
  private String shipTime;
  private String deliveryDate;
  private String deliveryTime;
  private String paymentMethod;
  private String shipFromName;
  private String shipFromNo;
  private String shipFromAddr;
  private String shipFromCity;
  private String shipFromState;
  private String shipFromZipCode;
  private String shipFromCountry;
  private String shipToName;
  private String shipToNo;
  private String shipToAddr;
  private String shipToCity;
  private String shipToState;
  private String shipToZipCode;
  private String shipToCountry;
  private String palletQty;
  private String tranStatus;
  private LocalDateTime createDttm;

}
