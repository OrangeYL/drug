package com.orange.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.drug.entity.ReturnSupplier;


public interface ReturnSupplierService extends IService<ReturnSupplier> {
    /**
     * 分页查询退货给供应商数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param 查询参数-退货给供应商名称
     * @return
     */
    public IPage<ReturnSupplier> queryReturnSupplierByPage(int pageNum,int pageSize,String param);
    /**
     * 新增一条退货给供应商信息
     * @param returnSupplier
     */
    public int addReturnSupplier(ReturnSupplier returnSupplier);
    /**
     * 根据主键id删除一个退货给供应商对象
     * @param id
     * @return
     */
    public int deleteReturnSupplier(Integer id);

    /**
     * 修改一条退货给供应商信息
     * @param returnSupplier
     */
    public int updateReturnSupplier(ReturnSupplier returnSupplier);
    /**
     * 根据主键id查询一个退货给供应商对象
     * @param id
     * @return
     */
    public ReturnSupplier queryReturnSupplierById(Integer id);
}
