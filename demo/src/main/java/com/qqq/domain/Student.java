package com.qqq.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}
