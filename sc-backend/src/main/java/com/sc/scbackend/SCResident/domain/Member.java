package com.sc.scbackend.SCResident.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("members")
public class Member extends BaseEntity {

    @TableId(value = "id")
    private Integer id;

    @TableField(value = "photo")
    private byte[] photo;

    @TableField(value = "property")
    private String property;

    @TableField(value = "name")
    private String name;

    @TableField(value = "identity_number")
    private String identityNumber;

    @TableField(value = "contact_info")
    private String contactInfo;

    @TableField(value = "occupation")
    private String occupation;

    @TableField(value = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @TableField(value = "gender")
    private String gender;

    @TableField(value = "member_type")
    private String memberType;

    @TableField(value = "remarks")
    private String remarks;

    @TableField(value = "status")
    private String status;

    @TableField(value = "created_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

}
