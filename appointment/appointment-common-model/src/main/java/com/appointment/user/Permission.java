package com.appointment.user;

import lombok.Data;

import java.util.Date;

@Data
public class Permission {
    private String id;
    private String name;
    private String code;
    private String pId;
    private Date createTime;
    private Date updateTime;
    private String state;
}
