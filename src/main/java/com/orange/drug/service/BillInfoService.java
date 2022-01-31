package com.orange.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.drug.entity.BillInfo;


public interface BillInfoService extends IService<BillInfo> {
    /**
     * 分页查询账单数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param 查询参数-账单名称
     * @return
     */
    public IPage<BillInfo> queryBillInfoByPage(int pageNum,int pageSize,String param);
    /**
     * 新增一条账单信息
     * @param billInfo
     */
    public int addBillInfo(BillInfo billInfo);
    /**
     * 根据主键id删除一个账单对象
     * @param id
     * @return
     */
    public int deleteBillInfo(Integer id);

    /**
     * 修改一条账单信息
     * @param billInfo
     */
    public int updateBillInfo(BillInfo billInfo);
    /**
     * 根据主键id查询一个账单对象
     * @param id
     * @return
     */
    public BillInfo queryBillInfoById(Integer id);
}
