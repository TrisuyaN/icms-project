package com.sc.scbackend.SCResident.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleInfoDTO {

    private Integer id;

    private String licensePlate;

    private byte[] registrationPhoto;

//    private Integer residentId;

    // 来自 'memberinfo' 表
    private String name;

    // 来自 'memberinfo' 表
    private String contactInfo;
}
