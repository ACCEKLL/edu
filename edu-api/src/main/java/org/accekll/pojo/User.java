package org.accekll.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
@TableName("t_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("loginName")
    private String loginName;

    @TableField("password")
    private String password;

    @TableField("passwordPro")
    private String passwordPro;

    @TableField("userName")
    private String userName;

    @TableField("userCode")
    private String userCode;

    @TableField("salt")
    private String salt;

    @TableField("role")
    private String role;



}
