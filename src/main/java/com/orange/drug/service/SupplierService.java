package com.orange.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.drug.entity.Supplier;

import java.util.List;


public interface SupplierService extends IService<Supplier> {
    /**
     * 分页查询供应商数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param 查询参数-供应商名称
     * @return
     */
    public IPage<Supplier> querySupplierByPage(int pageNum,int pageSize,String param);
    /**
     * 新增一条供应商信息
     * @param supplier
     */
    public int addSupplier(Supplier supplier);
    /**
     * 根据主键id删除一个供应商对象
     * @param id
     * @return
     */
    public int deleteSupplier(Integer id);

    /**
     * 修改一条供应商信息
     * @param supplier
     */
    public int updateSupplier(Supplier supplier);
    /**
     * 根据主键id查询一个供应商对象
     * @param id
     * @return
     */
    public Supplier querySupplierById(Integer id);
    /**
     * 查询所有供应商
     * @return
     */
    public List<Supplier> queryAllSupplier();
}
