package org.accekll.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.accekll.mapper.UserMapper;
import org.accekll.pojo.User;
import org.accekll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ZKL
 * @DataTime: 2022/8/19 14:05
 * @Description: 实现UserService接口后可以直接用UserService自动注入
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    //注入自己的Mapper
    @Autowired
    private UserMapper userMapper;


    //自己定义的Service方法,要实现接口中的方法
    @Override
    public Page<User> listPage(Page<User> page, QueryWrapper<User> wrapper) {
        return userMapper.selectPage(page, wrapper);
    }

    @Override
    public User getByLoginName(String loginName) {
        return userMapper.selectByLoginName(loginName);
    }


}
