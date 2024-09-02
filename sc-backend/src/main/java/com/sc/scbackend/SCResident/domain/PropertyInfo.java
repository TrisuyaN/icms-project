package com.sc.scbackend.SCResident.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("propertyinfo")
public class PropertyInfo extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "BuildingNumber")
    private Integer buildingNumber;

    @TableField(value = "PropertyCode")
    private String propertyCode;

    @TableField(value = "RoomNumber")
    private String roomNumber;

    @TableField(value = "OwnerName")
    private String ownerName;

    @TableField(value = "ContactInfo")
    private String contactInfo;

    @TableField(value = "Area")
    private BigDecimal area;

    @TableField(value = "NumberOfRooms")
    private Integer numberOfRooms;

    @TableField(value = "Unit")
    private String unit;

    @TableField(value = "FloorNumber")
    private Integer floorNumber;

    @TableField(value = "Description")
    private String description;

    @TableField(value = "MoveInDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date moveInDate;

}
