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
 * 退货给供应商实体类
 */
@Data
@TableName(value = "returnsupplier")
public class ReturnSupplier implements Serializable {
    /**
     * 主键id
     */
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 药品名称
     */
    private String drugName;
    /**
     * 药品数量
     */
    private Integer drugCount;
    /**
     * 供应商名称
     */
    private String supplierName;
    /**
     * 进货时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buyTime;
    /**
     * 退货原因
     */
    private String reason;
    /**
     * 退货时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /*退货时间转换成年月日*/
    public String getCreateTimeStr(){
        return createTime==null? null: DateUtil.dateConvert(createTime);
    }
    /*进货时间转换成年月日*/
    public String getBuyTimeStr(){
        return buyTime==null? null: DateUtil.dateConvert(buyTime);
    }
}
