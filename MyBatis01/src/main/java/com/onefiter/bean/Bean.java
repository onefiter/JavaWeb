package com.onefiter.bean;

import java.util.Date;

/**
 * author: onefiter
 * date: 2023/6/7
 */
public class Bean {
    private Integer id;
    private Date createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreateTime(Date createTime) {
        this.createdTime = createTime;
    }
}
