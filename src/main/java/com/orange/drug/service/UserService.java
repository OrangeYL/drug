package com.orange.drug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.drug.entity.User;

public interface UserService extends IService<User> {
    /**
     * 根据用户查询对象
     * @param user
     * @return
     */
    public User queryByUserName(User user);
}
