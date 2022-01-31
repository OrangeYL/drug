package com.orange.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.drug.entity.DrugInfo;
import com.orange.drug.entity.OwInfo;
import com.orange.drug.mapper.DrugInfoMapper;
import com.orange.drug.mapper.OwInfoMapper;
import com.orange.drug.service.DrugInfoService;
import com.orange.drug.service.OwInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 药品出入库service实现类
 */
@Service
public class OwInfoServiceImpl extends ServiceImpl<OwInfoMapper, OwInfo> implements OwInfoService {
    @Autowired
    private OwInfoMapper owInfoMapper;
    @Autowired
    private DrugInfoService drugInfoService;

    /**
     * 分页查询药品出入库数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param    查询参数-药品出入库名称
     * @return
     */
    @Override
    public IPage<OwInfo> queryOwInfoByPage(int pageNum, int pageSize, String param) {
        QueryWrapper<OwInfo> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            wrapper.like("drug_name",param);
        }
        Page<OwInfo> page = new Page<>(pageNum, pageSize);
        return owInfoMapper.selectPage(page,wrapper);
    }

    /**
     * 新增一条药品出入库信息
     *
     * @param owInfo
     */
    @Override
    public int addOwInfo(OwInfo owInfo) {
        DrugInfo queryDrugInfo = drugInfoService.queryDrugInfoByName(owInfo.getDrugName());
        if("出库".equals(owInfo.getType())){
            if(queryDrugInfo.getStock()<owInfo.getCount()){
                return -1;
            }
            queryDrugInfo.setStock(queryDrugInfo.getStock()-owInfo.getCount());
            drugInfoService.updateDrugInfo(queryDrugInfo);
        }else{
            queryDrugInfo.setStock(queryDrugInfo.getStock()+owInfo.getCount());
            drugInfoService.updateDrugInfo(queryDrugInfo);
        }
        return owInfoMapper.insert(owInfo);
    }

    /**
     * 根据主键id删除一个药品出入库对象
     *
     * @param id
     * @return
     */
    @Override
    public int deleteOwInfo(Integer id) {
        return owInfoMapper.deleteById(id);
    }

    /**
     * 修改一条药品出入库信息
     *
     * @param owInfo
     */
    @Override
    public int updateOwInfo(OwInfo owInfo) {
        return owInfoMapper.updateById(owInfo);
    }

    /**
     * 根据主键id查询一个药品出入库对象
     *
     * @param id
     * @return
     */
    @Override
    public OwInfo queryOwInfoById(Integer id) {
        return owInfoMapper.selectById(id);
    }

}
