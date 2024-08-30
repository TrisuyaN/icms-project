package com.sc.scbackend.domain;

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
@TableName("elevatorentries")
public class ElevatorEntry extends BaseEntity {

    @TableId(value = "EntryID")
    private String entryId;

    @TableField(value = "MemberID")
    private Integer memberId;

    @TableField(value = "EntryTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryTime;

}
