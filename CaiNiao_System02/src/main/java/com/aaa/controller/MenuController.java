package com.aaa.controller;

import com.aaa.biz.MenuBiz;
import com.aaa.entity.LayUiTable;
import com.aaa.entity.LayUiTree;
import com.aaa.entity.Menu;
import com.aaa.entity.Role;
import com.aaa.util.MyConstants;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 菜鸟团队
 * @Version 1.0
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuBiz menuBiz;
    @RequestMapping("/toShowMenu")
    public String toShowMenu() {
        return "menu/showMenu";
    }
    @RequestMapping("/selectAllMenu")
    @ResponseBody
    public List<LayUiTree> selectAllMenu(){
        List<LayUiTree> layUiTrees = menuBiz.selectAllMenu();
        System.out.println(layUiTrees);
        return layUiTrees;
    }
//    @RequestMapping("/selectAllMenu")
//    @ResponseBody
//    public List<Menu> selectAllMenu(){
//    List<Menu> menus = menuBiz.selectAllMenu();
//    System.out.println(menus);
//    return menus;
//}
    @RequestMapping("/toShowMenuTree")
    public String toShowMenuTree(){
        return "menu/showMenuTree2";
    }
    @RequestMapping("/showAllMenu")
    public LayUiTable showAllMenu(){
        List<LayUiTable> list = menuBiz.selectMenu();
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        //设置分页之后的返回值
        layUiTable.setCount(1000);
        layUiTable.setData(list);
        System.out.println(layUiTable);
        return layUiTable;}

        //菜单管理
    @RequestMapping("/toShowMenu2")
    public String toShowMenu2() {
        return "menu/showMenu2";
    }
    @RequestMapping("/showMenu2")
    @ResponseBody
    public LayUiTable showMenu2(int page, int limit) {
        //开始查询
        PageInfo<Menu> pageInfo = menuBiz.selectAllMenu(page, limit);
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        //设置分页之后的返回值
        layUiTable.setCount(pageInfo.getTotal());
        layUiTable.setData(pageInfo.getList());
        return layUiTable;
    }
    @RequestMapping("/savemenu")
    @ResponseBody
    public Object savemenu(Menu menuInfo){
        int i = menuBiz.insertSelective(menuInfo);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",MyConstants.successCode);
            map.put("message",MyConstants.saveSuccessMsg);
        }else {
            map.put("code", MyConstants.failCode);
            map.put("message",MyConstants.saveFailMsg);
        }
        return map;
    }
    @RequestMapping("/delMenu")
    @ResponseBody
    public Object delMenu( @RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<String> list= (List<String>) JSON.parse(ids);
        System.out.println(list);
        int i = menuBiz.delMenuByID(list);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",MyConstants.successCode);
            map.put("message",MyConstants.delSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.delFailMsg);
        }
        return map;
    }
    @RequestMapping("/editMenu")
    @ResponseBody
    public Object editMenu(Menu menuInfo){
        int i = menuBiz.updateByPrimaryKeySelective(menuInfo);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",MyConstants.successCode);
            map.put("message",MyConstants.editSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.editFailMsg);
        }
        return map;
    }
    @RequestMapping("/searchMenuById")
    @ResponseBody
    public LayUiTable searchMenuById(int menuId){

        System.out.println(menuId);
        List<Menu> list = menuBiz.searchMenuById(menuId);
        System.out.println(list);
        LayUiTable layUiTable =new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        //设置分页之后的返回值
        layUiTable.setCount(1);
        layUiTable.setData(list);
        return layUiTable;
    }
}
