package com.onefiter.common;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * author: onefiter
 * date: 2023/6/7
 */
public class DruidDataSourceFactory extends UnpooledDataSourceFactory {
    public DruidDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }
}
