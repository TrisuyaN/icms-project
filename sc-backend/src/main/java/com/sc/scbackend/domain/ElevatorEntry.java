package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("elevatorentries")
public class ElevatorEntry {

    @TableId(value = "EntryID")
    private String entryId;

    @TableField(value = "MemberID")
    private Integer memberId;

    @TableField(value = "EntryTime")
    private Date entryTime;

}
