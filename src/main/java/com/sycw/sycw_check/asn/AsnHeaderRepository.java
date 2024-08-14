package com.sycw.sycw_check.asn;

import com.sycw.sycw_check.entity.ASNHeaderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface AsnHeaderRepository {

    @Select("select * from tb_ewh856s where TRAN_STATUS = '15'")
    public List<ASNHeaderEntity> selectNotCompleteList();

    @Select("select CUSTOMER_NO,CUSTOMER_NAME from tb_cm0700 where CUSTOMER_NO in ('901013','910020','901104','901113','903008')")
    public List<Map<String,Object>> selectAsnCustomer();

    @Update("update tb_ewh856s " +
            "set TRAN_STATUS = '20' " +
            "where INTERFACE_ID = #{INTERFACE_ID} " +
            "and FUNCTION_CODE = #{FUNCTION_CODE} " +
            "and SI_NO = #{SI_NO} " +
            "and SHIPMENT_ITEM_NO = #{SHIPMENT_ITEM_NO}" +
            "and TRAN_STATUS = '15'")
    int updateState20(
            @Param("INTERFACE_ID") String interfaceId,
            @Param("FUNCTION_CODE") String functionCode,
            @Param("SI_NO") String siNo,
            @Param("SHIPMENT_ITEM_NO") String shipmentItemNo
    );

    @Select({
        "select",
        "a.*,b.*",
        "from",
        "tb_ecw830 a",
        "inner join tb_ecw831 b on a.IF_KEY = b.IF_KEY"
    })
    List<Map<String,Object>> findAllCowayGrCompleteItems();
}
