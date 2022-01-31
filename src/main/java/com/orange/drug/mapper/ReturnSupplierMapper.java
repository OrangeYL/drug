package com.orange.drug.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orange.drug.entity.ReturnGoods;
import com.orange.drug.entity.ReturnSupplier;
import org.springframework.stereotype.Repository;

/**
 * 退货给供应商mapper接口
 */
@Repository
public interface ReturnSupplierMapper extends BaseMapper<ReturnSupplier> {
}
