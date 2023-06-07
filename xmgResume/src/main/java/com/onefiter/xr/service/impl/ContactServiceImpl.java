package com.onefiter.xr.service.impl;

import com.onefiter.xr.bean.Contact;
import com.onefiter.xr.bean.ContactListParam;
import com.onefiter.xr.bean.ContactListResult;
import com.onefiter.xr.dao.ContactDao;
import com.onefiter.xr.service.ContactService;


public class ContactServiceImpl extends BaseServiceImpl<Contact> implements ContactService {

    @Override
    public ContactListResult list(ContactListParam param) {
        return ((ContactDao) dao).list(param);
    }

    @Override
    public boolean read(Integer id) {
        return ((ContactDao) dao).read(id);
    }
}
