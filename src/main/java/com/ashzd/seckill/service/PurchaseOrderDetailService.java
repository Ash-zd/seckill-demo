package com.ashzd.seckill.service;

import com.ashzd.seckill.dto.PurchaseOrderDetailDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @file: PurchaseOrderDetailService
 * @author: Ash
 * @date: 2019/7/23 15:37
 * @description:
 * @since:
 **/
public interface PurchaseOrderDetailService {

    BigDecimal addAndReturnTotalPrice(PurchaseOrderDetailDTO orderDetailDTO);

    List<PurchaseOrderDetailDTO> query(String orderIndexCode);

}
