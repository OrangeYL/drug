package com.orange.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orange.drug.common.ResultMap;
import com.orange.drug.entity.SaleInfo;
import com.orange.drug.service.SaleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
@RequestMapping("/saleInfo")
public class SaleInfoController {

    @Autowired
    private SaleInfoService saleInfoService;

    /**
     * 转向销售记录页面
     * @return
     */
    @RequestMapping
    public String saleInfo(){
        return "/saleInfo";
    }

    /**
     * 分页查询销售记录数据
     * @param pageNum
     * @param pageSize
     * @param param
     * @return
     */
    @RequestMapping("/querySaleInfoByPage")
    @ResponseBody
    public Object  querySaleInfoByPage(@RequestParam(value = "page",defaultValue = "1") int pageNum,
                                       @RequestParam(value = "limit",defaultValue = "10") int pageSize,
                                       String param){
        try {
            IPage<SaleInfo> page = saleInfoService.querySaleInfoByPage(pageNum, pageSize, param);
            return ResultMap.getHashMapPage(page);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 转向销售记录新增页面
     * @return
     */
    @RequestMapping(value = "/saleInfoPage")
    public String saleInfoPage(){
        return "/saleInfoPage";
    }

    /**
     * 添加一个销售记录
     */
    @RequestMapping(value = "/addSaleInfo")
    @ResponseBody
    public Object addSaleInfo(SaleInfo saleInfo){
        try {
            int i = saleInfoService.addSaleInfo(saleInfo);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 删除一个销售记录
     */
    @RequestMapping(value = "/deleteSaleInfo")
    @ResponseBody
    public Object deleteSaleInfo(Integer id){
        try{
            int i = saleInfoService.deleteSaleInfo(id);
            return ResultMap.getHashMapDel(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


    /**
     * 转向销售记录编辑页面
     */
    @RequestMapping(value = "/saleInfoQueryById")
    public String saleInfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        SaleInfo saleInfo = saleInfoService.querySaleInfoById(id);
        model.addAttribute("obj",saleInfo);
        return "/saleInfoPage";
    }

    /**
     * 修改一个销售记录
     */
    @RequestMapping(value = "/updateSaleInfo")
    @ResponseBody
    public Object updateSaleInfo(SaleInfo saleInfo){
        try{
            int i = saleInfoService.updateSaleInfo(saleInfo);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

}
