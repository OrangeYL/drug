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
 * 账单信息实体类
 */
@Data
@TableName(value = "billinfo")
public class BillInfo implements Serializable {
    /**
     * 主键id
     */
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 供应商名称
     */
    private String supplierName;
    /**
     * 药品名称
     */
    private String drugName;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 总金额
     */
    private Float total;
    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buyTime;

    /*操作时间转换成年月日*/
    public String getBuyTimeStr(){
        return buyTime==null? null: DateUtil.dateConvert(buyTime);
    }
}
