package com.onefiter.xr.dao;

import com.onefiter.xr.bean.Contact;
import com.onefiter.xr.bean.ContactListParam;
import com.onefiter.xr.bean.ContactListResult;

public interface ContactDao extends BaseDao<Contact> {
    ContactListResult list(ContactListParam param);
    boolean read(Integer id);
}
