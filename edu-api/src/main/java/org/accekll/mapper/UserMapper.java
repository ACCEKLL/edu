package org.accekll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.accekll.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: ZKL
 * @DataTime: 2022/8/18 18:32
 * @Description:
 **/
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user where loginName = #{loginName} ")
    User selectByLoginName(String loginName);

}
