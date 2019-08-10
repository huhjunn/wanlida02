package com.appointment.company;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

//@TableName("ds_appointment")
@Data
public class Company {
    private Long id;
    private String dsName;
    private String password;
    private String name;
    private String phone;
    private Date applicationDate;
    private String shortMessage;
    private String dailyAppointment;
    private String weeklyAppointment;
    private String coachCancelTime;
    private String studentCancelTime;
    private String lateNum;
    private String truancyNum;
}
