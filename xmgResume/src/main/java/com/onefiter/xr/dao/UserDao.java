package com.onefiter.xr.dao;

import com.onefiter.xr.bean.User;

public interface UserDao extends BaseDao<User> {
    User get(User user);
}
