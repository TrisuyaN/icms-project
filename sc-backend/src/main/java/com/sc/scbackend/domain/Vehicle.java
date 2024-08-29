package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("vehicles")
public class Vehicle {

    @TableId(value = "id")
    private Integer id;

    @TableField(value = "license_plate")
    private String licensePlate;

    @TableField(value = "registration_photo")
    private byte[] registrationPhoto;

    @TableField(value = "resident_id")
    private Integer residentId;
}
