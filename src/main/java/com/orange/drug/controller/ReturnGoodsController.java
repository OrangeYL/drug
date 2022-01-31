package com.orange.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orange.drug.common.ResultMap;
import com.orange.drug.entity.ReturnGoods;
import com.orange.drug.service.ReturnGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/returnGoods")
public class ReturnGoodsController {

    @Autowired
    private ReturnGoodsService returnGoodsService;

    /**
     * 转向退货页面
     * @return
     */
    @RequestMapping
    public String returnGoods(){
        return "/returnGoods";
    }

    /**
     * 分页查询退货数据
     * @param pageNum
     * @param pageSize
     * @param param
     * @return
     */
    @RequestMapping("/queryReturnGoodsByPage")
    @ResponseBody
    public Object  queryReturnGoodsByPage(@RequestParam(value = "page",defaultValue = "1") int pageNum,
                                       @RequestParam(value = "limit",defaultValue = "10") int pageSize,
                                       String param){
        try {
            IPage<ReturnGoods> page = returnGoodsService.queryReturnGoodsByPage(pageNum, pageSize, param);
            return ResultMap.getHashMapPage(page);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 转向退货新增页面
     * @return
     */
    @RequestMapping(value = "/returnGoodsPage")
    public String returnGoodsPage(){
        return "/returnGoodsPage";
    }

    /**
     * 添加一个退货
     */
    @RequestMapping(value = "/addReturnGoods")
    @ResponseBody
    public Object addReturnGoods(ReturnGoods returnGoods){
        try {
            int i = returnGoodsService.addReturnGoods(returnGoods);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e) {
            return ResultMap.getHashMapException(e);
        }
    }

    /**
     * 删除一个退货
     */
    @RequestMapping(value = "/deleteReturnGoods")
    @ResponseBody
    public Object deleteReturnGoods(Integer id){
        try{
            int i = returnGoodsService.deleteReturnGoods(id);
            return ResultMap.getHashMapDel(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


    /**
     * 转向退货编辑页面
     */
    @RequestMapping(value = "/returnGoodsQueryById")
    public String returnGoodsQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        ReturnGoods returnGoods = returnGoodsService.queryReturnGoodsById(id);
        model.addAttribute("obj",returnGoods);
        return "/returnGoodsPage";
    }

    /**
     * 修改一个退货
     */
    @RequestMapping(value = "/updateReturnGoods")
    @ResponseBody
    public Object updateReturnGoods(ReturnGoods returnGoods){
        try{
            int i = returnGoodsService.updateReturnGoods(returnGoods);
            return ResultMap.getResultMapSave(i);
        } catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

}
