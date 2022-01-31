package com.orange.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orange.drug.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户mapper接口
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
