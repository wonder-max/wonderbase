package com.aaa.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: 菜鸟团队
 * @Version 1.0
 */
@Data
public class LayUiTable {
    private int code;
    private String msg;
    private long count;
    private List<?> data;
}
