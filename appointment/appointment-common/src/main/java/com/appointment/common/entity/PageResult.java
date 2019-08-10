package com.appointment.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *   封装到响应对象Result的date里面
 */
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T>{
    private long total;//总条数
    private List<T> rows;//数据列表
}
