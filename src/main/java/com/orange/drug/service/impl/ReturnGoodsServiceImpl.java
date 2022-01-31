package com.orange.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.drug.entity.ReturnGoods;
import com.orange.drug.mapper.ReturnGoodsMapper;
import com.orange.drug.service.ReturnGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 退货service实现类
 */
@Service
public class ReturnGoodsServiceImpl extends ServiceImpl<ReturnGoodsMapper, ReturnGoods> implements ReturnGoodsService {
    @Autowired
    private ReturnGoodsMapper returnGoodsMapper;

    /**
     * 分页查询退货数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param    查询参数-退货名称
     * @return
     */
    @Override
    public IPage<ReturnGoods> queryReturnGoodsByPage(int pageNum, int pageSize, String param) {
        QueryWrapper<ReturnGoods> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            wrapper.like("drug_name",param);
        }
        Page<ReturnGoods> page = new Page<>(pageNum, pageSize);
        return returnGoodsMapper.selectPage(page,wrapper);
    }

    /**
     * 新增一条退货信息
     *
     * @param returnGoods
     */
    @Override
    public int addReturnGoods(ReturnGoods returnGoods) {
        return returnGoodsMapper.insert(returnGoods);
    }

    /**
     * 根据主键id删除一个退货对象
     *
     * @param id
     * @return
     */
    @Override
    public int deleteReturnGoods(Integer id) {
        return returnGoodsMapper.deleteById(id);
    }

    /**
     * 修改一条退货信息
     *
     * @param returnGoods
     */
    @Override
    public int updateReturnGoods(ReturnGoods returnGoods) {
        return returnGoodsMapper.updateById(returnGoods);
    }

    /**
     * 根据主键id查询一个退货对象
     *
     * @param id
     * @return
     */
    @Override
    public ReturnGoods queryReturnGoodsById(Integer id) {
        return returnGoodsMapper.selectById(id);
    }

}
