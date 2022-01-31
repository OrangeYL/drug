package com.orange.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.drug.entity.BillInfo;
import com.orange.drug.mapper.BillInfoMapper;
import com.orange.drug.service.BillInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 账单service实现类
 */
@Service
public class BillInfoServiceImpl extends ServiceImpl<BillInfoMapper, BillInfo> implements BillInfoService {
    @Autowired
    private BillInfoMapper billInfoMapper;

    /**
     * 分页查询账单数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param    查询参数-账单名称
     * @return
     */
    @Override
    public IPage<BillInfo> queryBillInfoByPage(int pageNum, int pageSize, String param) {
        QueryWrapper<BillInfo> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            wrapper.like("supplier_name",param);
        }
        Page<BillInfo> page = new Page<>(pageNum, pageSize);
        return billInfoMapper.selectPage(page,wrapper);
    }

    /**
     * 新增一条账单信息
     *
     * @param billInfo
     */
    @Override
    public int addBillInfo(BillInfo billInfo) {
        return billInfoMapper.insert(billInfo);
    }

    /**
     * 根据主键id删除一个账单对象
     *
     * @param id
     * @return
     */
    @Override
    public int deleteBillInfo(Integer id) {
        return billInfoMapper.deleteById(id);
    }

    /**
     * 修改一条账单信息
     *
     * @param billInfo
     */
    @Override
    public int updateBillInfo(BillInfo billInfo) {
        return billInfoMapper.updateById(billInfo);
    }

    /**
     * 根据主键id查询一个账单对象
     *
     * @param id
     * @return
     */
    @Override
    public BillInfo queryBillInfoById(Integer id) {
        return billInfoMapper.selectById(id);
    }

}
