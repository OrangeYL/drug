package com.orange.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商实体类
 */
@Data
@TableName(value = "supplier")
public class Supplier implements Serializable {
    /**
     * 主键id
     */
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 供应商名称
     */
    private String name;
    /**
     * 供应商描述
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
}
