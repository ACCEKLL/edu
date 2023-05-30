package org.accekll.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author: ZKL
 * @DataTime: 2022/8/19 19:24
 * @Description: 封装返回前端的数据
 **/
@Data
@AllArgsConstructor
public class Ret<T> {

    private int code;

    private String msg;

    private List<T> list;

    private Long total;

    private String token;

}
