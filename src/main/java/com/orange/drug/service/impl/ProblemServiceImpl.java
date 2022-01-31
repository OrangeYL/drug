package com.orange.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.drug.entity.DrugInfo;
import com.orange.drug.entity.Problem;
import com.orange.drug.mapper.ProblemMapper;
import com.orange.drug.service.DrugInfoService;
import com.orange.drug.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 问题药品service实现类
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private DrugInfoService drugInfoService;

    /**
     * 分页查询问题药品数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param    查询参数-问题药品名称
     * @return
     */
    @Override
    public IPage<Problem> queryProblemByPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Problem> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            wrapper.like("drug_name",param);
        }
        Page<Problem> page = new Page<>(pageNum, pageSize);
        return problemMapper.selectPage(page,wrapper);
    }

    /**
     * 新增一条问题药品信息
     *
     * @param problem
     */
    @Override
    public int addProblem(Problem problem) {
        return problemMapper.insert(problem);
    }

    /**
     * 根据主键id删除一个问题药品对象
     *
     * @param id
     * @return
     */
    @Override
    public int deleteProblem(Integer id) {
        return problemMapper.deleteById(id);
    }

    /**
     * 修改一条问题药品信息
     *
     * @param problem
     */
    @Override
    public int updateProblem(Problem problem) {
        return problemMapper.updateById(problem);
    }

    /**
     * 根据主键id查询一个问题药品对象
     *
     * @param id
     * @return
     */
    @Override
    public Problem queryProblemById(Integer id) {
        return problemMapper.selectById(id);
    }

}
