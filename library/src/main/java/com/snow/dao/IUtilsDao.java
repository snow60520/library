package com.snow.dao;

import org.springframework.stereotype.Repository;

/**
 * 一些共用接口
 */
@Repository
public interface IUtilsDao {
    /**
     * 1,查询表里数据总条数，用于分页( select COUNT(*) from tableName
     * @param tableName 传入表名
     * @return 返回Integer count(*)条数
     */
    Integer selTableRowCount(String tableName);
}
