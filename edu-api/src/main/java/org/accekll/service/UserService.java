package org.accekll.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.accekll.pojo.User;
import org.accekll.utils.MD5;
import org.accekll.utils.RandomUtil;


/**
 * @Author: ZKL
 * @DataTime: 2022/8/18 18:33
 * @Description:
 **/
public interface UserService extends IService<User> {

    @Override
    default boolean save(User entity) {
        entity.setSalt(RandomUtil.getRandomString(5));
        entity.setPasswordPro(MD5.md5(entity.getPassword(), entity.getSalt()));
        return IService.super.save(entity);
    }

    //需要在接口中定义一个方法，再实现这个方法，否则用UserService自动注入后无法使用实现类中的方法
    Page<User> listPage(Page<User> page, QueryWrapper<User> wrapper);

    User getByLoginName(String loginName);


}
