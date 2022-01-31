package com.orange.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orange.drug.common.ResultMap;
import com.orange.drug.entity.Problem;
import com.orange.drug.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    /**
     * 转向问题药品页面
     * @return
     */
    @RequestMapping
    public String problem(){
        return "/problem";
    }

    /**
     * 分页查询问题药品数据
     * @param pageNum
     * @param pageSize
     * @param param
     * @return
     */
    @RequestMapping("/queryProblemByPage")
    @ResponseBody
    public Object  queryProblemByPage(@RequestParam(value = "page",defaultValue = "1") int pageNum,
                                       @RequestParam(value = "limit",defaultValue = "10") int pageSize,
                                       String param){
        try {
            IPage<Problem> page = problemService.queryProblemByPage(pageNum, pageSize, param);
            return ResultMap.getHashMapPage(page);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 转向问题药品新增页面
     * @return
     */
    @RequestMapping(value = "/problemPage")
    public String problemPage(){
        return "/problemPage";
    }

    /**
     * 添加一个问题药品
     */
    @RequestMapping(value = "/addProblem")
    @ResponseBody
    public Object addProblem(Problem problem){
        problem.setCreateTime(new Date());
        try {
            int i = problemService.addProblem(problem);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 删除一个问题药品
     */
    @RequestMapping(value = "/deleteProblem")
    @ResponseBody
    public Object deleteProblem(Integer id){
        try{
            int i = problemService.deleteProblem(id);
            return ResultMap.getHashMapDel(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


    /**
     * 转向问题药品编辑页面
     */
    @RequestMapping(value = "/problemQueryById")
    public String problemQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Problem problem = problemService.queryProblemById(id);
        model.addAttribute("obj",problem);
        return "/problemPage";
    }

    /**
     * 修改一个问题药品
     */
    @RequestMapping(value = "/updateProblem")
    @ResponseBody
    public Object updateProblem(Problem problem){
        try{
            int i = problemService.updateProblem(problem);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

}
