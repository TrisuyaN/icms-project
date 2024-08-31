package com.sc.scbackend.SCResident.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("vehicles")
public class Vehicle extends BaseEntity {

    @TableId(value = "id")
    private Integer id;

    @TableField(value = "license_plate")
    private String licensePlate;

    @TableField(value = "registration_photo")
    private byte[] registrationPhoto;

    @TableField(value = "resident_id")
    private Integer residentId;
}
