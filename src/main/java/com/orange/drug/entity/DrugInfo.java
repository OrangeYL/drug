package com.orange.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.orange.drug.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 药品实体类
 */
@Data
@TableName(value = "druginfo")
public class DrugInfo implements Serializable {
    /**
     * 主键id
     */
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 药品名称
     */
    private String name;
    /**
     * 供应商名称
     */
    private String supplier;
    /**
     * 生产时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productTime;
    /**
     * 保质期（月）
     */
    private String warranty;
    /**
     * 编号
     */
    private String number;
    /**
     * 价格
     */
    private Float price;
    /**
     * 库存
     */
    private Integer stock;

    /*生产时间转换成年月日*/
    public String getProductTimeStr(){
        return productTime==null? null: DateUtil.dateConvert(productTime);
    }
}
