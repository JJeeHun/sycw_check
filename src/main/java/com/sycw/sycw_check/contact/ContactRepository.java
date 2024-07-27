package com.sycw.sycw_check.contact;

import com.sycw.sycw_check.contact.dto.ContactDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ContactRepository {

    @Select({
    "<script>",
        "select",
        "    b.CONTACT_ORD_NO as contactOrderNo,",
        "    sum(a.ITEM_QTY) as qty",
        "from tb_po0801 a",
        "left join tb_po0800 b on a.SYSTEM_ORDER_NO = b.SYSTEM_ORDER_NO",
        "where b.CONTACT_ORD_NO in",
        "<foreach item='contactOrderNo' collection='contactOrderNos' open='(' close=')' separator=','>",
            "#{contactOrderNo}",
        "</foreach>",
        "group by b.CONTACT_ORD_NO",
    "</script>"
    })
    public List<ContactDTO> orderQty(List<String> contactOrderNos);

    @Select({
            "<script>",
            "select",
            "    a.CONTACT_ORD_NO as contactOrderNo,",
            "    sum(GI_QTY) as qty",
            "from tb_oo0100 a",
            "where a.CONTACT_ORD_NO in",
            "<foreach item='contactOrderNo' collection='contactOrderNos' open='(' close=')' separator=','>",
            "#{contactOrderNo}",
            "</foreach>",
            "group by a.CONTACT_ORD_NO",
            "</script>"
    })
    public List<ContactDTO> giQty(List<String> contactOrderNos);

    @Select({
            "<script>",
            "select",
            "    a.CONTACT_ORD_NO as contactOrderNo,",
            "    sum(PLANNED_QTY) as qty",
            "from tb_oo0201 a",
            "where a.CONTACT_ORD_NO in",
            "<foreach item='contactOrderNo' collection='contactOrderNos' open='(' close=')' separator=','>",
            "#{contactOrderNo}",
            "</foreach>",
            "group by a.CONTACT_ORD_NO",
            "</script>"
    })
    public List<ContactDTO> shippingInstructionQty(List<String> contactOrderNos);

    @Select({
            "<script>",
            "select",
            "    a.CONTACT_ORD_NO as contactOrderNo,",
            "    sum(PI_PLAN_QTY) as qty",
            "from tb_oo0300 a",
            "where a.CONTACT_ORD_NO in",
            "<foreach item='contactOrderNo' collection='contactOrderNos' open='(' close=')' separator=','>",
            "#{contactOrderNo}",
            "</foreach>",
            "group by a.CONTACT_ORD_NO",
            "</script>"
    })
    public List<ContactDTO> pickingPlanQty(List<String> contactOrderNos);

    @Select({
            "<script>",
            "select",
            "    a.CONTACT_ORD_NO as contactOrderNo,",
            "    sum(PICKING_QTY) as qty",
            "from tb_oo0400 a",
            "where a.CONTACT_ORD_NO in",
            "<foreach item='contactOrderNo' collection='contactOrderNos' open='(' close=')' separator=','>",
            "#{contactOrderNo}",
            "</foreach>",
            "group by a.CONTACT_ORD_NO",
            "</script>"
    })
    public List<ContactDTO> pickingQty(List<String> contactOrderNos);

    @Select({
            "<script>",
            "select",
            "    a.CONTACT_ORD_NO as contactOrderNo,",
            "    sum(QTY) as qty",
            "from tb_oo0500 a",
            "where a.CONTACT_ORD_NO in",
            "<foreach item='contactOrderNo' collection='contactOrderNos' open='(' close=')' separator=','>",
            "#{contactOrderNo}",
            "</foreach>",
            "group by a.CONTACT_ORD_NO",
            "</script>"
    })
    public List<ContactDTO> giClosingQty(List<String> contactOrderNos);
}
