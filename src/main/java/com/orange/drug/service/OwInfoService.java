package com.orange.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.drug.entity.OwInfo;



public interface OwInfoService extends IService<OwInfo> {
    /**
     * 分页查询药品出入库数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param 查询参数-药品出入库名称
     * @return
     */
    public IPage<OwInfo> queryOwInfoByPage(int pageNum,int pageSize,String param);
    /**
     * 新增一条药品出入库信息
     * @param owInfo
     */
    public int addOwInfo(OwInfo owInfo);
    /**
     * 根据主键id删除一个药品出入库对象
     * @param id
     * @return
     */
    public int deleteOwInfo(Integer id);

    /**
     * 修改一条药品出入库信息
     * @param owInfo
     */
    public int updateOwInfo(OwInfo owInfo);
    /**
     * 根据主键id查询一个药品出入库对象
     * @param id
     * @return
     */
    public OwInfo queryOwInfoById(Integer id);
}
