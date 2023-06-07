package com.onefiter.xr.service.impl;

import com.onefiter.xr.bean.User;
import com.onefiter.xr.dao.UserDao;
import com.onefiter.xr.service.UserService;


public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Override
    public User get(User user) {
        return ((UserDao) dao).get(user);
    }
}
