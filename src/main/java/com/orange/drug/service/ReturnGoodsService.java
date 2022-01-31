package com.orange.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.drug.entity.ReturnGoods;


public interface ReturnGoodsService extends IService<ReturnGoods> {
    /**
     * 分页查询退货数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param 查询参数-退货名称
     * @return
     */
    public IPage<ReturnGoods> queryReturnGoodsByPage(int pageNum,int pageSize,String param);
    /**
     * 新增一条退货信息
     * @param returnGoods
     */
    public int addReturnGoods(ReturnGoods returnGoods);
    /**
     * 根据主键id删除一个退货对象
     * @param id
     * @return
     */
    public int deleteReturnGoods(Integer id);

    /**
     * 修改一条退货信息
     * @param returnGoods
     */
    public int updateReturnGoods(ReturnGoods returnGoods);
    /**
     * 根据主键id查询一个退货对象
     * @param id
     * @return
     */
    public ReturnGoods queryReturnGoodsById(Integer id);
}
