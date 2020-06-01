package com.aaa.biz;

import com.aaa.entity.Dept;
import com.aaa.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 菜鸟团队
 * @Version 1.0
 */
public interface DeptBiz {
   List<Dept> selectAllDept();
   int insertSelective(Dept record);
   int updateByPrimaryKeySelective(Dept record);
   int delDeptById(@Param("ids") List<String> ids);
   List<Dept> searchDeptById(int deptId);
}
