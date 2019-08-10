package com.appointment.company;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String name;
    private String sex;
    private String phone;
    private String password;
    private Date birthday;
    private String idcard;
    private String subject;
    private String teachAge;
    private String shortMessage;
    private String image;
    private String coachId;
    private String state;
}
