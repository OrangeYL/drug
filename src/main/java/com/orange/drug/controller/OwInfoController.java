package com.orange.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orange.drug.common.ResultMap;
import com.orange.drug.entity.OwInfo;
import com.orange.drug.service.OwInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
@RequestMapping("/owInfo")
public class OwInfoController {

    @Autowired
    private OwInfoService owInfoService;

    /**
     * 转向药品出入库页面
     * @return
     */
    @RequestMapping
    public String owInfo(){
        return "/owInfo";
    }

    /**
     * 分页查询药品出入库数据
     * @param pageNum
     * @param pageSize
     * @param param
     * @return
     */
    @RequestMapping("/queryOwInfoByPage")
    @ResponseBody
    public Object  queryOwInfoByPage(@RequestParam(value = "page",defaultValue = "1") int pageNum,
                                       @RequestParam(value = "limit",defaultValue = "10") int pageSize,
                                       String param){
        try {
            IPage<OwInfo> page = owInfoService.queryOwInfoByPage(pageNum, pageSize, param);
            return ResultMap.getHashMapPage(page);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 转向药品出入库新增页面
     * @return
     */
    @RequestMapping(value = "/owInfoPage")
    public String owInfoPage(){
        return "/owInfoPage";
    }

    /**
     * 添加一个药品出入库
     */
    @RequestMapping(value = "/addOwInfo")
    @ResponseBody
    public Object addOwInfo(OwInfo owInfo){
        owInfo.setCreateTime(new Date());
        try {
            int i = owInfoService.addOwInfo(owInfo);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 删除一个药品出入库
     */
    @RequestMapping(value = "/deleteOwInfo")
    @ResponseBody
    public Object deleteOwInfo(Integer id){
        try{
            int i = owInfoService.deleteOwInfo(id);
            return ResultMap.getHashMapDel(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


    /**
     * 转向药品出入库编辑页面
     */
    @RequestMapping(value = "/owInfoQueryById")
    public String owInfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        OwInfo owInfo = owInfoService.queryOwInfoById(id);
        model.addAttribute("obj",owInfo);
        return "/owInfoPage";
    }

    /**
     * 修改一个药品出入库
     */
    @RequestMapping(value = "/updateOwInfo")
    @ResponseBody
    public Object updateOwInfo(OwInfo owInfo){
        try{
            int i = owInfoService.updateOwInfo(owInfo);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

}
