package com.orange.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orange.drug.common.ResultMap;
import com.orange.drug.entity.ReturnSupplier;
import com.orange.drug.service.ReturnSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/returnSupplier")
public class ReturnSupplierController {

    @Autowired
    private ReturnSupplierService returnSupplierService;

    /**
     * 转向退货给供应商页面
     * @return
     */
    @RequestMapping
    public String returnSupplier(){
        return "/returnSupplier";
    }

    /**
     * 分页查询退货给供应商数据
     * @param pageNum
     * @param pageSize
     * @param param
     * @return
     */
    @RequestMapping("/queryReturnSupplierByPage")
    @ResponseBody
    public Object  queryReturnSupplierByPage(@RequestParam(value = "page",defaultValue = "1") int pageNum,
                                       @RequestParam(value = "limit",defaultValue = "10") int pageSize,
                                       String param){
        try {
            IPage<ReturnSupplier> page = returnSupplierService.queryReturnSupplierByPage(pageNum, pageSize, param);
            return ResultMap.getHashMapPage(page);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 转向退货给供应商新增页面
     * @return
     */
    @RequestMapping(value = "/returnSupplierPage")
    public String returnSupplierPage(){
        return "/returnSupplierPage";
    }

    /**
     * 添加一个退货给供应商
     */
    @RequestMapping(value = "/addReturnSupplier")
    @ResponseBody
    public Object addReturnSupplier(ReturnSupplier returnSupplier){
        try {
            int i = returnSupplierService.addReturnSupplier(returnSupplier);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 删除一个退货给供应商
     */
    @RequestMapping(value = "/deleteReturnSupplier")
    @ResponseBody
    public Object deleteReturnSupplier(Integer id){
        try{
            int i = returnSupplierService.deleteReturnSupplier(id);
            return ResultMap.getHashMapDel(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


    /**
     * 转向退货给供应商编辑页面
     */
    @RequestMapping(value = "/returnSupplierQueryById")
    public String returnSupplierQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        ReturnSupplier returnSupplier = returnSupplierService.queryReturnSupplierById(id);
        model.addAttribute("obj",returnSupplier);
        return "/returnSupplierPage";
    }

    /**
     * 修改一个退货给供应商
     */
    @RequestMapping(value = "/updateReturnSupplier")
    @ResponseBody
    public Object updateReturnSupplier(ReturnSupplier returnSupplier){
        try{
            int i = returnSupplierService.updateReturnSupplier(returnSupplier);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

}
