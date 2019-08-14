package com.ashzd.seckill.mapper;

import com.ashzd.seckill.entity.PurchaseOrderDetail;
import com.ashzd.seckill.entity.PurchaseOrderDetailExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurchaseOrderDetailMapper {
    long countByExample(PurchaseOrderDetailExample example);

    int deleteByExample(PurchaseOrderDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseOrderDetail record);

    int insertSelective(PurchaseOrderDetail record);

    List<PurchaseOrderDetail> selectByExample(PurchaseOrderDetailExample example);

    PurchaseOrderDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PurchaseOrderDetail record, @Param("example") PurchaseOrderDetailExample example);

    int updateByExample(@Param("record") PurchaseOrderDetail record, @Param("example") PurchaseOrderDetailExample example);

    int updateByPrimaryKeySelective(PurchaseOrderDetail record);

    int updateByPrimaryKey(PurchaseOrderDetail record);
}