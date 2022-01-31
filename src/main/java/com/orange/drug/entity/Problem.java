package com.orange.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题药品实体类
 */
@Data
@TableName(value = "problem")
public class Problem implements Serializable {
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
     * 问题药品数量
     */
    private Integer drugCount;
    /**
     * 药品单价
     */
    private Float drugPrice;
    /**
     * 问题原因
     */
    private String reason;
    /**
     * 操作时间
     */
    private Date createTime;
}
