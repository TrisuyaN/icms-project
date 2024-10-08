package com.sc.scbackend.SCPending.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.SCPending.enums.WarningType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("extremeweather")
public class ExtremeWeather extends BaseEntity {

    @TableId(value = "WeatherID")
    private String weatherId;

    @TableField(value = "WeatherName")
    private String weatherName;

    @TableField(value = "WarningType")
    private WarningType warningType;

    @TableField(value = "ResponseMeasures")
    private String responseMeasures;

    @TableField(value = "ExpectedTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expectedTime;

}
