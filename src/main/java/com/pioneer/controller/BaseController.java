package com.pioneer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pioneer.service.BaseSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private BaseSevice baseSevice;

    @RequestMapping("/set")
    @ResponseBody
    public String set(HttpServletRequest request) {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        String code = request.getParameter("code");

        if (!"hank@1989".equals(code) || null == value) {
            return "failure";
        }

        String dbValue = this.get(request);
        if ("key not exist".equals(dbValue)) {
            String insertSql = "insert into h_map(h_key,h_value) VALUES ('" + key + "','" + value + "')";
            baseSevice.insert(insertSql);
        } else {
            String updateSql = "update h_map set h_value = '" + value + "' where h_key ='" + key + "'";
            baseSevice.update(updateSql);
        }
        return "success";
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(HttpServletRequest request) {
        String key = request.getParameter("key");
        String sql = "select h_value from h_map where h_key = '" + key + "'";
        String dbValue = baseSevice.select(sql);
        if (dbValue != null) {
            return dbValue;
        } else {
            return "key not exist";
        }
    }


    @RequestMapping("/insertOneRecord")
    @ResponseBody
    public String insertOneRecord(HttpServletRequest request) {
        String table = request.getParameter("table");
        String keys = request.getParameter("keys");
        String values = request.getParameter("values");
        String code = request.getParameter("code");

        if (!"hank@1989".equals(code)) {
            return "failure";
        }

        String insertSql = "insert into " + table + "(" + keys + ") VALUES (" + values + ")";
        baseSevice.insert(insertSql);
        return "success";
    }


    @RequestMapping("/updateOneRecord")
    @ResponseBody
    public String updateOneRecord(HttpServletRequest request) {
        String table = request.getParameter("table");
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        String code = request.getParameter("code");
        String id = request.getParameter("id");

        if (!"hank@1989".equals(code)) {
            return "failure";
        }
        String updateSql = "update " + table + " set " + key + " = '" + value + "' where id ='" + id + "'";
        baseSevice.update(updateSql);
        return "success";
    }

    @RequestMapping("/deleteOneRecord")
    @ResponseBody
    public String deleteOneRecord(HttpServletRequest request) {
        String table = request.getParameter("table");
        String code = request.getParameter("code");
        String id = request.getParameter("id");

        if (!"hank@1989".equals(code)) {
            return "failure";
        }
        String updateSql = "delete from  " + table + " where id = '" + id + "'";
        baseSevice.update(updateSql);
        return "success";
    }

    @RequestMapping("/selectRecords")
    @ResponseBody
    public Object selectRecords(HttpServletRequest request) {
        String table = request.getParameter("table");
        String fields = request.getParameter("fields");
        String condition = request.getParameter("condition");

        if (null == table) {
            return "table is empty";
        }
        if (null == fields) {
            fields = "*";
        }
        if (null == condition) {
            condition = "where 1 = 1 ";
        } else {
            JSONObject jsonObject = JSON.parseObject(condition);
            StringBuilder newCondition = new StringBuilder("where 1 = 1 ");
            for (String key : jsonObject.keySet()) {
                newCondition.append(" and ").append(key).append(" = \"").append(jsonObject.getString(key)).append("\"");
            }
            condition = newCondition.toString();

        }

        String sql = "select " + fields + " from " + table + " " + condition + "";
        List<Map<String, Object>> resultMap = baseSevice.selectListMap(sql);
        return resultMap;
    }

}