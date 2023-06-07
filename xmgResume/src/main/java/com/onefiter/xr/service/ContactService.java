package com.onefiter.xr.service;

import com.onefiter.xr.bean.Contact;
import com.onefiter.xr.bean.ContactListParam;
import com.onefiter.xr.bean.ContactListResult;

public interface ContactService extends BaseService<Contact> {
    ContactListResult list(ContactListParam param);
    boolean read(Integer id);
}
