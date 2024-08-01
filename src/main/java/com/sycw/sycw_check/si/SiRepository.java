package com.sycw.sycw_check.si;

import com.sycw.sycw_check.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface SiRepository {

    @Select({"<script>" ,
            "select a.SI_NO as siNo," ,
            "       a.ETD as etd," ,
            "       count(a.SI_NO) as detailCnt," ,
            "       count(b.SI_NO) as headCnt " ,
            "from tb_oo0201 a " ,
            "left join tb_oo0200 b on a.SI_NO = b.SI_NO and a.ETD = b.ETD " ,
            "where a.SYSTEM_ORDER_NO in (" ,
            "    select SYSTEM_ORDER_NO from tb_po0800 where ORDER_RECEIPT_DATE = #{date}" ,
            ") " ,
            "group by a.SI_NO,a.ETD,b.SI_NO" ,
            "</script>"})
    public List<Map<String,Object>> findSiNoList(LocalDate date);

    @Select({"<script>" ,
            "select * from tb_oo0201 where SI_NO in" ,
            "<foreach item='siNo' collection='siNoList' open='(' close=')' separator=','>",
            "#{siNo}",
            "</foreach>",
            "order by SI_NO,SI_ITEM_NO",
            "</script>"})
    public List<ShippingEntity> findShippingAll(List<String> siNoList);

    @Select({"<script>" ,
            "select * from tb_oo0300 where SI_NO in" ,
            "<foreach item='siNo' collection='siNoList' open='(' close=')' separator=','>",
            "#{siNo}",
            "</foreach>",
            "order by SI_NO,SI_ITEM_NO",
            "</script>"})
    public List<PickingPlanEntity> findPlanAll(List<String> siNoList);

    @Select({"<script>" ,
            "select * from tb_oo0400 where SI_NO in" ,
            "<foreach item='siNo' collection='siNoList' open='(' close=')' separator=','>",
            "#{siNo}",
            "</foreach>",
            "order by SI_NO,SI_ITEM_NO",
            "</script>"})
    public List<PickingEntity> findPickingAll(List<String> siNoList);

    @Select({"<script>" ,
            "select * from tb_oo0500 where SI_NO in" ,
            "<foreach item='siNo' collection='siNoList' open='(' close=')' separator=','>",
            "#{siNo}",
            "</foreach>",
            "order by SI_NO,SI_ITEM_NO",
            "</script>"})
    public List<ClosingEntity> findClosingAll(List<String> siNoList);

    @Select({"<script>" ,
            "select * from tb_su753d where SI_NO in" ,
            "<foreach item='siNo' collection='siNoList' open='(' close=')' separator=','>",
            "#{siNo}",
            "</foreach>",
            "</script>"})
    public List<Sending753Entity> findSending753All(List<String> siNoList);

    @Select({"<script>" ,
            "select * from tb_su856d where SI_NO in" ,
            "<foreach item='siNo' collection='siNoList' open='(' close=')' separator=','>",
            "#{siNo}",
            "</foreach>",
            "</script>"})
    public List<Sending856Entity> findSending856All(List<String> siNoList);




}
