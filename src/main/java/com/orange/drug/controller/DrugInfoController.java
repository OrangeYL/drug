package com.orange.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orange.drug.common.ResultMap;
import com.orange.drug.entity.DrugInfo;
import com.orange.drug.service.DrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/drugInfo")
public class DrugInfoController {

    @Autowired
    private DrugInfoService drugInfoService;

    /**
     * 转向药品页面
     * @return
     */
    @RequestMapping
    public String drugInfo(){
        return "/drugInfo";
    }

    /**
     * 分页查询药品数据
     * @param pageNum
     * @param pageSize
     * @param param
     * @return
     */
    @RequestMapping("/queryDrugInfoByPage")
    @ResponseBody
    public Object  queryDrugInfoByPage(@RequestParam(value = "page",defaultValue = "1") int pageNum,
                                       @RequestParam(value = "limit",defaultValue = "10") int pageSize,
                                       String param){
        try {
            IPage<DrugInfo> page = drugInfoService.queryDrugInfoByPage(pageNum, pageSize, param);
            return ResultMap.getHashMapPage(page);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 转向药品新增页面
     * @return
     */
    @RequestMapping(value = "/drugInfoPage")
    public String drugInfoPage(){
        return "/drugInfoPage";
    }

    /**
     * 添加一个药品
     */
    @RequestMapping(value = "/addDrugInfo")
    @ResponseBody
    public Object addDrugInfo(DrugInfo drugInfo){
        try {
            int i = drugInfoService.addDrugInfo(drugInfo);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 删除一个药品
     */
    @RequestMapping(value = "/deleteDrugInfo")
    @ResponseBody
    public Object deleteDrugInfo(Integer id){
        try{
            int i = drugInfoService.deleteDrugInfo(id);
            return ResultMap.getHashMapDel(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


    /**
     * 转向药品编辑页面
     */
    @RequestMapping(value = "/drugInfoQueryById")
    public String drugInfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        DrugInfo drugInfo = drugInfoService.queryDrugInfoById(id);
        model.addAttribute("obj",drugInfo);
        return "/drugInfoPage";
    }

    /**
     * 修改一个药品
     */
    @RequestMapping(value = "/updateDrugInfo")
    @ResponseBody
    public Object updateDrugInfo(DrugInfo drugInfo){
        try{
            int i = drugInfoService.updateDrugInfo(drugInfo);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 获取所有药品
     */
    @RequestMapping(value = "/drugInfoList")
    @ResponseBody
    public Object drugInfoList(){
        List<DrugInfo> drugInfoList = drugInfoService.queryAllDrugInfo();
        return ResultMap.getHashMapList(drugInfoList);
    }

    /**
     * 转向药品页保质期页面
     * @return
     */
    @RequestMapping("/warranty")
    public String warranty(){
        return "/warranty";
    }
}
