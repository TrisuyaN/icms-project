package com.sc.scbackend.SCResident.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class MemberPropertyInfoDTO {

    private Integer id;

    private byte[] photo;

    private Integer buildingNumber;

    private String name;

    private String identityNumber;

    private String contactInfo;

    private String occupation;

    private Date birthDate;

    private String gender;

    private String memberType;

    private String remarks;

    private String roomNumber;

    private String unit;

    private Integer floorNumber;

}
