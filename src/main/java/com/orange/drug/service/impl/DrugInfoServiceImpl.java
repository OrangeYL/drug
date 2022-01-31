package com.orange.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.drug.entity.DrugInfo;
import com.orange.drug.mapper.DrugInfoMapper;
import com.orange.drug.service.DrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药品service实现类
 */
@Service
public class DrugInfoServiceImpl extends ServiceImpl<DrugInfoMapper, DrugInfo> implements DrugInfoService {
    @Autowired
    private DrugInfoMapper drugInfoMapper;

    /**
     * 分页查询药品数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param    查询参数-药品名称
     * @return
     */
    @Override
    public IPage<DrugInfo> queryDrugInfoByPage(int pageNum, int pageSize, String param) {
        QueryWrapper<DrugInfo> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            wrapper.like("name",param);
        }
        Page<DrugInfo> page = new Page<>(pageNum, pageSize);
        return drugInfoMapper.selectPage(page,wrapper);
    }

    /**
     * 新增一条药品信息
     *
     * @param drugInfo
     */
    @Override
    public int addDrugInfo(DrugInfo drugInfo) {
        return drugInfoMapper.insert(drugInfo);
    }

    /**
     * 根据主键id删除一个药品对象
     *
     * @param id
     * @return
     */
    @Override
    public int deleteDrugInfo(Integer id) {
        return drugInfoMapper.deleteById(id);
    }

    /**
     * 修改一条药品信息
     *
     * @param drugInfo
     */
    @Override
    public int updateDrugInfo(DrugInfo drugInfo) {
        return drugInfoMapper.updateById(drugInfo);
    }

    /**
     * 根据主键id查询一个药品对象
     *
     * @param id
     * @return
     */
    @Override
    public DrugInfo queryDrugInfoById(Integer id) {
        return drugInfoMapper.selectById(id);
    }

    /**
     * 查询所有药品
     *
     * @return
     */
    @Override
    public List<DrugInfo> queryAllDrugInfo() {
        return drugInfoMapper.selectList(null);
    }

    /**
     * 根据药品名字查询一个药品对象
     *
     * @param name
     * @return
     */
    @Override
    public DrugInfo queryDrugInfoByName(String name) {
        QueryWrapper<DrugInfo> drugInfoQueryWrapper = new QueryWrapper<>();
        drugInfoQueryWrapper.eq("name",name);
        return drugInfoMapper.selectOne(drugInfoQueryWrapper);
    }
}
