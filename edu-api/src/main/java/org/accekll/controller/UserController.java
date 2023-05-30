package org.accekll.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.accekll.exception.BusinessException;
import org.accekll.exception.BusinessExceptionEnum;
import org.accekll.pojo.User;
import org.accekll.service.UserService;
import org.accekll.utils.JwtUtil;
import org.accekll.utils.Ret;
import org.accekll.utils.Rets;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


@RestController
@RequestMapping({"/users"})
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/account")
    public User getAccount(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        String loginName = JwtUtil.getUsername(token);
        return userService.getByLoginName(loginName);
    }

    @GetMapping()
    public Ret<?> myGet(@RequestParam(required = false) Long pageSize,
                        @RequestParam(required = false) Long currentPage,
                        @RequestParam(required = false) String loginName,
                        @RequestParam(required = false) String userName,
                        @RequestParam(required = false) String userCode
    ) {
        Page<User> page = new Page<>(currentPage, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("loginName", loginName)
                .like("userName", userName)
                .like("userCode", userCode);
        Page<User> resultPage = userService.listPage(page, wrapper);
        return Rets.resultList(resultPage);
    }

    @RequiresPermissions("admin")
    @DeleteMapping("/{id}")
    public Ret<?> myDelete(@PathVariable int id) {
        if (!userService.removeById(id)) {
            throw new BusinessException(BusinessExceptionEnum.FAIL_DELETE_USER);
        }
        return Rets.success();
    }

    @RequiresPermissions("admin")
    @PostMapping
    public Ret<?> myInsert(@RequestBody User user) {
        if (userService.getByLoginName(user.getLoginName()) != null){
            throw new BusinessException(BusinessExceptionEnum.ACCOUNT_ALREADY_EXISTED);
        }
        if(!userService.save(user)) {
            throw new BusinessException(BusinessExceptionEnum.FAIL_NEW_USER);
        }
        return Rets.success();
    }

    @RequiresPermissions("admin")
    @PutMapping
    public Ret<?> myUpdate(@RequestBody User user) {
        User userByNewLoginName = userService.getByLoginName(user.getLoginName());
        if(userByNewLoginName != null && !Objects.equals(userByNewLoginName.getId(), user.getId())){
            throw new BusinessException(BusinessExceptionEnum.ACCOUNT_ALREADY_EXISTED);
        }
        if(!userService.updateById(user)) {
            throw new BusinessException(BusinessExceptionEnum.FAIL_UPDATE_USER);
        }
        return Rets.success();
    }

}
