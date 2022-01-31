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
 * 退货实体类
 */
@Data
@TableName(value = "returngoods")
public class ReturnGoods implements Serializable {
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
     * 数量
     */
    private Integer count;
    /**
     * 退货原因
     */
    private String reason;
    /**
     * 总金额
     */
    private Float total;
    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operateTime;

    /*操作时间转换成年月日*/
    public String getOperateTimeStr(){
        return operateTime==null? null: DateUtil.dateConvert(operateTime);
    }
}
