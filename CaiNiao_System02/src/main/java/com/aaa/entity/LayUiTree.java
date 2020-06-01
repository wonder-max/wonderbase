package com.aaa.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: 菜鸟团队
 * @Version 1.0
 */
@Data
public class LayUiTree {

    private String title;
    private int id;
    private String field;
    private boolean checked;
    private boolean spread;
    private String url;
    private List<LayUiTree> children;


}
