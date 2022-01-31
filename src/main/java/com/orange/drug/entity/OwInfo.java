package com.orange.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 出入库实体类
 */
@Data
@TableName(value = "owinfo")
public class OwInfo implements Serializable {
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
     * 出库/入库
     */
    private String type;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 操作时间
     */
    private Date createTime;
}
