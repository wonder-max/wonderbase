package com.aaa.biz.impl;

import com.aaa.biz.DeptBiz;
import com.aaa.dao.DeptMapper;
import com.aaa.entity.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 菜鸟团队
 * @Version 1.0
 */
@Service
public class DeptBizImpl implements DeptBiz {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectAllDept();
    }
    @Override
    public int insertSelective(Dept record){return deptMapper.insertSelective(record);}
    @Override
    public int updateByPrimaryKeySelective(Dept record){return deptMapper.updateByPrimaryKeySelective(record);}
    @Override
    public int delDeptById(List<String> ids){return deptMapper.delDeptById(ids);}
    @Override
    public List<Dept> searchDeptById(int deptId){return deptMapper.searchDeptById(deptId);}
}