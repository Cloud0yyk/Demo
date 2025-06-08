package com.cloud.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@TableName
@Getter
@Builder
public class User implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private Long userId;

    @TableField
    private String username;

    @TableField
    private String password;

    @TableField
    private Boolean isAdmin = false;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
