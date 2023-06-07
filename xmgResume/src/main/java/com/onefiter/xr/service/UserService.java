package com.onefiter.xr.service;

import com.onefiter.xr.bean.User;

public interface UserService extends BaseService<User> {
    User get(User user);
}
