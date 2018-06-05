package com.pioneer.service;

import java.util.List;
import java.util.Map;

/**
 * @author hankun
 * @date 2018/6/5
 */
public interface BaseSevice {
    void insert(String sql);

    void update(String sql);

    void delete(String sql);

    String select(String sql);

    Map<String, Object> selectMap(String sql);

    List<Map<String, Object>> selectListMap(String sql);
}
