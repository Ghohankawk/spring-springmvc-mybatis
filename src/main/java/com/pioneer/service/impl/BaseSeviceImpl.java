package com.pioneer.service.impl;

import com.pioneer.mapper.BaseMapper;
import com.pioneer.service.BaseSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author hankun
 * @date 2018/6/5
 */
@Service
public class BaseSeviceImpl implements BaseSevice {
    @Autowired
    private BaseMapper<?> mapper;

    @Override
    public void insert(String sql) {
        mapper.insertSql(sql);
    }

    @Override
    public void update(String sql) {
        mapper.updateSql(sql);
    }

    @Override
    public void delete(String sql) {
        mapper.deleteSql(sql);
    }

    @Override
    public String select(String sql) {
        return mapper.selectSql(sql);
    }

    @Override
    public Map<String, Object> selectMap(String sql) {
        return mapper.selectMapSql(sql);
    }

    @Override
    public List<Map<String, Object>> selectListMap(String sql) {
        return mapper.selectListMapSql(sql);
    }
}
