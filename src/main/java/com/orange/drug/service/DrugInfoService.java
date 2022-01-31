package com.orange.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.drug.entity.DrugInfo;

import java.util.List;


public interface DrugInfoService extends IService<DrugInfo> {
    /**
     * 分页查询药品数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param 查询参数-药品名称
     * @return
     */
    public IPage<DrugInfo> queryDrugInfoByPage(int pageNum,int pageSize,String param);
    /**
     * 新增一条药品信息
     * @param drugInfo
     */
    public int addDrugInfo(DrugInfo drugInfo);
    /**
     * 根据主键id删除一个药品对象
     * @param id
     * @return
     */
    public int deleteDrugInfo(Integer id);

    /**
     * 修改一条药品信息
     * @param drugInfo
     */
    public int updateDrugInfo(DrugInfo drugInfo);
    /**
     * 根据主键id查询一个药品对象
     * @param id
     * @return
     */
    public DrugInfo queryDrugInfoById(Integer id);
    /**
     * 查询所有药品
     * @return
     */
    public List<DrugInfo> queryAllDrugInfo();

    /**
     * 根据药品名字查询一个药品对象
     * @param name
     * @return
     */
    public DrugInfo queryDrugInfoByName(String name);

}
