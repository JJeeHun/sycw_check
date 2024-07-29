package com.sycw.sycw_check.api;

import com.sycw.sycw_check.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Mapper
public interface OrderApiRepository {

    @Select("select * from tb_po0801 where system_order_no = #{systemOrderNo}")
    public List<OrderItemEntity> findOrderItemAll(String systemOrderNo);

    @Select("select * from tb_oo0201 where system_order_no = #{systemOrderNo} and item_no = #{itemNo}")
    public List<ShippingEntity> findShippingAll(String systemOrderNo, Long itemNo);

    @Select("select * from tb_oo0300 where oord_no = #{oordNo} and oord_item_no = #{oordItemNo}")
    public List<PickingPlanEntity> findPickingPlanAll(String oordNo, String oordItemNo);

    @Select("select * from tb_oo0400 where system_order_no = #{systemOrderNo} and oord_item_no = #{itemNo}")
    public List<PickingEntity> findPickingAll(String systemOrderNo, Long itemNo);

    @Select("select * from tb_oo0500 where system_order_no = #{systemOrderNo} and oord_item_no = #{itemNo}")
    public List<ClosingEntity> findClosingAll(String systemOrderNo, Long itemNo);
}
