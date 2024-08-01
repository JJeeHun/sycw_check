package com.sycw.sycw_check.si;

import com.sycw.sycw_check.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SiRepository {

    @Select("select * from tb_po0801 where SYSTEM_ORDER_NO in (select tb_po0800.SYSTEM_ORDER_NO from tb_po0800 where CONTACT_ORD_NO = #{contactOrderNo}) order by system_order_no, item_no")
    List<OrderItemEntity> findOrderItem(String contactOrderNo);

    @Select("select * from tb_oo0201 where CONTACT_ORD_NO = #{contactOrderNo} order by system_order_no, item_no")
    List<ShippingEntity> findShipping(String contactOrderNo);

    @Select("select * from tb_oo0300 where CONTACT_ORD_NO = #{contactOrderNo} order by SI_NO,SI_ITEM_NO,ETD")
    List<PickingPlanEntity> findPlan(String contactOrderNo);

    @Select("select * from tb_oo0400 where CONTACT_ORD_NO = #{contactOrderNo} order by system_order_no,oord_item_no")
    List<PickingEntity> findPicking(String contactOrderNo);

    @Select("select * from tb_oo0500 where CONTACT_ORD_NO = #{contactOrderNo} order by system_order_no,oord_item_no")
    List<ClosingEntity> findClosing(String contactOrderNo);

    @Select("select * from tb_su753d where CONTACT_ORD_NO = #{contactOrderNo} order by SI_NO,ITEM_NO,CREATE_DATE")
    List<Sending753Entity> findSending753(String contactOrderNo);

    @Select("select * from tb_su856d where CONTACT_ORD_NO = #{contactOrderNo} order by SI_NO,SEQ,CREATE_DATE")
    List<Sending856Entity> findSending856(String contactOrderNo);
}
