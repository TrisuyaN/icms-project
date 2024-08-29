package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.enums.ComplaintStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("complaintinfo")
public class Complaint extends BaseEntity {

    @TableId(value = "ID")
    private String id;

    private String content;

    @TableField(value = "ComplaintStatus")
    private ComplaintStatus complaintStatus;

    @TableField(value = "ComplainantID")
    private String complainantId;

    private String handler;

}
