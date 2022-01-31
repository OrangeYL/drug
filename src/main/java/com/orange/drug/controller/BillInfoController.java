package com.orange.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orange.drug.common.ResultMap;
import com.orange.drug.entity.BillInfo;
import com.orange.drug.service.BillInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/billInfo")
public class BillInfoController {

    @Autowired
    private BillInfoService billInfoService;

    /**
     * 转向账单页面
     * @return
     */
    @RequestMapping
    public String billInfo(){
        return "/billInfo";
    }

    /**
     * 分页查询账单数据
     * @param pageNum
     * @param pageSize
     * @param param
     * @return
     */
    @RequestMapping("/queryBillInfoByPage")
    @ResponseBody
    public Object  queryBillInfoByPage(@RequestParam(value = "page",defaultValue = "1") int pageNum,
                                       @RequestParam(value = "limit",defaultValue = "10") int pageSize,
                                       String param){
        try {
            IPage<BillInfo> page = billInfoService.queryBillInfoByPage(pageNum, pageSize, param);
            return ResultMap.getHashMapPage(page);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 转向账单新增页面
     * @return
     */
    @RequestMapping(value = "/billInfoPage")
    public String billInfoPage(){
        return "/billInfoPage";
    }

    /**
     * 添加一个账单
     */
    @RequestMapping(value = "/addBillInfo")
    @ResponseBody
    public Object addBillInfo(BillInfo billInfo){
        try {
            int i = billInfoService.addBillInfo(billInfo);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 删除一个账单
     */
    @RequestMapping(value = "/deleteBillInfo")
    @ResponseBody
    public Object deleteBillInfo(Integer id){
        try{
            int i = billInfoService.deleteBillInfo(id);
            return ResultMap.getHashMapDel(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


    /**
     * 转向账单编辑页面
     */
    @RequestMapping(value = "/billInfoQueryById")
    public String billInfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        BillInfo billInfo = billInfoService.queryBillInfoById(id);
        model.addAttribute("obj",billInfo);
        return "/billInfoPage";
    }

    /**
     * 修改一个账单
     */
    @RequestMapping(value = "/updateBillInfo")
    @ResponseBody
    public Object updateBillInfo(BillInfo billInfo){
        try{
            int i = billInfoService.updateBillInfo(billInfo);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

}
