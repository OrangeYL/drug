package com.orange.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orange.drug.common.ResultMap;
import com.orange.drug.entity.Supplier;
import com.orange.drug.service.SupplierService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * 转向供应商页面
     * @return
     */
    @RequestMapping
    public String supplier(){
        return "/supplier";
    }

    /**
     * 分页查询供应商数据
     * @param pageNum
     * @param pageSize
     * @param param
     * @return
     */
    @RequestMapping("/querySupplierByPage")
    @ResponseBody
    public Object  querySupplierByPage(@RequestParam(value = "page",defaultValue = "1") int pageNum,
                                       @RequestParam(value = "limit",defaultValue = "10") int pageSize,
                                       String param){
        try {
            IPage<Supplier> page = supplierService.querySupplierByPage(pageNum, pageSize, param);
            return ResultMap.getHashMapPage(page);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 转向供应商新增页面
     * @return
     */
    @RequestMapping(value = "/supplierPage")
    public String supplierPage(){
        return "/supplierPage";
    }

    /**
     * 添加一个供应商
     */
    @RequestMapping(value = "/addSupplier")
    @ResponseBody
    public Object addSupplier(Supplier supplier){
        try {
            supplier.setCreateTime(new Date());
            int i = supplierService.addSupplier(supplier);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 删除一个供应商
     */
    @RequestMapping(value = "/deleteSupplier")
    @ResponseBody
    public Object deleteSupplier(Integer id){
        try{
            int i = supplierService.deleteSupplier(id);
            return ResultMap.getHashMapDel(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


    /**
     * 转向供应商编辑页面
     */
    @RequestMapping(value = "/supplierQueryById")
    public String supplierQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Supplier supplier = supplierService.querySupplierById(id);
        model.addAttribute("obj",supplier);
        return "/supplierPage";
    }

    /**
     * 修改一个供应商
     */
    @RequestMapping(value = "/updateSupplier")
    @ResponseBody
    public Object updateSupplier(Supplier supplier){
        try{
            int i = supplierService.updateSupplier(supplier);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 获取所有供应商
     */
    @RequestMapping(value = "/supplierList")
    @ResponseBody
    public Object supplierList(){
        List<Supplier> supplierList = supplierService.queryAllSupplier();
        return ResultMap.getHashMapList(supplierList);
    }
}
