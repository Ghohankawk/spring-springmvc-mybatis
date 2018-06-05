package com.pioneer.mapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
    /**
     * 简单的插入数据库的sql语句
     * @param sql
     */
    void insertSql(String sql);
    /**
     * 简单的更新sql语句
     * @param sql
     */
    void updateSql(String sql);
    /**
     * 简单的删除sql语句
     * @param sql
     */
    void deleteSql(String sql);

    /**
     * 简单的查询数据库的sql语句,单个结果，单个字段
     * @param sql
     */
    String selectSql(String sql);

    /**
     * 简单的查询数据库的sql语句,单个结果，多个字段
     * @param sql
     */
    Map<String,Object> selectMapSql(String sql);

    /**
     * 简单的查询数据库的sql语句,多个结果，多个字段
     * @param sql
     */
    List<Map<String,Object>> selectListMapSql(String sql);
}