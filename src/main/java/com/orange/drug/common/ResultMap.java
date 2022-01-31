package com.orange.drug.common;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给前端返回json格式的数据
 */
public class ResultMap {
    /**
     * 登录返回结果
     * @param msg
     * @param code
     * @return
     */
    public static Map<String,Object> getLoginResultMap(String msg, String code){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg",msg);
        map.put("code",code);
        if("1".equals(code)){
            map.put("icon",1);
        }else{
            map.put("icon",3);
        }
        map.put("anim",4);
        return map;
    }

    /**
     * 分页查询结果
     * @param object
     * @return
     */
    public static Map<String,Object> getHashMapPage(IPage<?> object){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",object.getTotal());
        map.put("data",object.getRecords());
        return map;
    }

    /**
     * 统一异常处理
     * @param e
     * @return
     */
    public static Map<String,Object> getHashMapException(Exception e){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg",e.getMessage());
        return map;
    }

    /**
     * 保存成功统一格式
     * @param i
     * @return
     */
    public static Map<String,Object> getResultMapSave(int i){
        HashMap<String, Object> map = new HashMap<>();
        if(i==0){
            map.put("msg","保存失败");
            map.put("code",1);
            map.put("icon",5);
            map.put("anim",6);
        }else if(i==-1){
            map.put("msg","库存不足");
            map.put("code",1);
            map.put("icon",5);
            map.put("anim",6);
        }else{
            map.put("msg","保存成功");
            map.put("code",0);
            map.put("icon",1);
            map.put("anim",4);
        }
        return map;
    }

    /**
     * 删除成功的统一返回格式
     */
    public static HashMap<String,Object> getHashMapDel(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","删除失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","删除成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;
    }

    /**
     * List返回格式
     */
    public static HashMap<String,Object> getHashMapList(List<?> list){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        if(list!=null&&list.size()>0){
            resultMap.put("msg","");
        }else {
            resultMap.put("msg","没有查询到数据！");
        }
        resultMap.put("data",list);
        return resultMap;
    }

}
