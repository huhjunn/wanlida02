package com.hujun.demo0621.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class PePermission  implements Serializable {
    private String id;
    private String name;
    private String code;
    private String description;
}
