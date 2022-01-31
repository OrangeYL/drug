package com.orange.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.drug.entity.Problem;


public interface ProblemService extends IService<Problem> {
    /**
     * 分页查询问题药品数据
     * @param pageNum  第几页
     * @param pageSize 每页多大
     * @param param 查询参数-问题药品名称
     * @return
     */
    public IPage<Problem> queryProblemByPage(int pageNum,int pageSize,String param);
    /**
     * 新增一条问题药品信息
     * @param problem
     */
    public int addProblem(Problem problem);
    /**
     * 根据主键id删除一个问题药品对象
     * @param id
     * @return
     */
    public int deleteProblem(Integer id);

    /**
     * 修改一条问题药品信息
     * @param problem
     */
    public int updateProblem(Problem problem);
    /**
     * 根据主键id查询一个问题药品对象
     * @param id
     * @return
     */
    public Problem queryProblemById(Integer id);
}
