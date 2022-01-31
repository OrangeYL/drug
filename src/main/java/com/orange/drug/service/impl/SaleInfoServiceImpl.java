package com.orange.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.drug.entity.SaleInfo;
import com.orange.drug.mapper.SaleInfoMapper;
import com.orange.drug.service.SaleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 销售记录service实现类
 */
@Service
public class SaleInfoServiceImpl extends ServiceImpl<SaleInfoMapper, SaleInfo> implements SaleInfoService {
    @Autowired
    private SaleInfoMapper saleInfoMapper;

    /**
     * 分页查询销售记录数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param    查询参数-销售记录名称
     * @return
     */
    @Override
    public IPage<SaleInfo> querySaleInfoByPage(int pageNum, int pageSize, String param) {
        QueryWrapper<SaleInfo> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            wrapper.like("drug_name",param);
        }
        Page<SaleInfo> page = new Page<>(pageNum, pageSize);
        return saleInfoMapper.selectPage(page,wrapper);
    }

    /**
     * 新增一条销售记录信息
     *
     * @param saleInfo
     */
    @Override
    public int addSaleInfo(SaleInfo saleInfo) {
        return saleInfoMapper.insert(saleInfo);
    }

    /**
     * 根据主键id删除一个销售记录对象
     *
     * @param id
     * @return
     */
    @Override
    public int deleteSaleInfo(Integer id) {
        return saleInfoMapper.deleteById(id);
    }

    /**
     * 修改一条销售记录信息
     *
     * @param saleInfo
     */
    @Override
    public int updateSaleInfo(SaleInfo saleInfo) {
        return saleInfoMapper.updateById(saleInfo);
    }

    /**
     * 根据主键id查询一个销售记录对象
     *
     * @param id
     * @return
     */
    @Override
    public SaleInfo querySaleInfoById(Integer id) {
        return saleInfoMapper.selectById(id);
    }

}
