package com.aaa.controller;

import com.aaa.biz.UserBiz;
import com.aaa.entity.LayUiTable;
import com.aaa.entity.MyUserInfo;
import com.aaa.entity.User;
import com.aaa.util.MyConstants;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Author: 菜鸟团队
 * @Version 1.0
 */
@Controller
//此处的RequestMapping是窄化请求，1年级
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserBiz userBizImpl;

    @RequestMapping("/toShowUser")
    public String toShowUserLayui() {
        return "user/showUser";
    }

    @RequestMapping("/showUser")
    @ResponseBody
    public LayUiTable showUserLayui(int page, int limit) {
        //开始查询
        PageInfo<User> pageInfo = userBizImpl.selectAllUser(page, limit);
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        //设置分页之后的返回值
        layUiTable.setCount(pageInfo.getTotal());
        layUiTable.setData(pageInfo.getList());


        return layUiTable;
    }
    @RequestMapping("/searchUserById")
    @ResponseBody
    public LayUiTable searchUserById(int userId){

        System.out.println(userId);
        List<User> list = userBizImpl.searchUserById(userId);
        System.out.println(list);
        LayUiTable layUiTable =new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        //设置分页之后的返回值
        layUiTable.setCount(1);
        layUiTable.setData(list);
        return layUiTable;
    }

    @RequestMapping("/resetPassword")
    @ResponseBody
    public Object resetPassword(User userInfo){
        System.out.println(userInfo);
        int i = userBizImpl.resetPassword(userInfo);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code",MyConstants.successCode);
            map.put("message",MyConstants.resetSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.resetFailMsg);
        }
        return map;
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public Object saveUser(User userInfo){
        //判断开关传过来的status是不是null 如果是 就设置为1
        String s = userInfo.getStatus();
        if(s==null){userInfo.setStatus("1");}
        int i = userBizImpl.insertSelective(userInfo);
        userBizImpl.insertUserRoleId(userInfo);

        Map map= new HashMap<>();
        if(i>0){
            map.put("code",MyConstants.successCode);
            map.put("message",MyConstants.saveSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.saveFailMsg);
        }
        return map;
    }


    @RequestMapping("/editUser")
    @ResponseBody
    public Object editUser(User userInfo){
        String s = userInfo.getStatus();
        if(s==null){userInfo.setStatus("1");}
        int i = userBizImpl.updateByPrimaryKeySelective(userInfo);
        userBizImpl.updateUserRoleById(userInfo);
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
    @RequestMapping("/delUser")
    @ResponseBody
    public Object delUser( @RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<String> list= (List<String>) JSON.parse(ids);
        System.out.println("user"+list);
        int i = userBizImpl.delUserByID(list);
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

}
