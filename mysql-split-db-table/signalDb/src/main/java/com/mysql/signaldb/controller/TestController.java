package com.mysql.signaldb.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.signaldb.dao.UserDao;
import com.mysql.signaldb.entity.RoleInfoBean;
import com.mysql.signaldb.entity.UserInfoReq;
import com.mysql.signaldb.entity.UserQueryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * @author HCW
 * @date 2023/4/13 13:56
 * @todo
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private UserDao userDao;

    @PostMapping("queryUser")
    public String queryUser(@RequestBody UserQueryBean req, HttpServletRequest request) {
        List<UserQueryBean> userQueryBeans = userDao.selectUserInfo(req);
        JSONArray jsonArray = new JSONArray(Collections.singletonList(userQueryBeans));
        return jsonArray.toString();
    }

    @PostMapping("addUser")
    public String addUser(@RequestBody UserInfoReq req, HttpServletRequest request) {
        userDao.insertUserInfo(req);
        return req.getUserId() + "";
    }

    @PostMapping("updateUser")
    public String update(@RequestBody UserInfoReq req, HttpServletRequest request) {
        userDao.updateUserInfo(req);
        return req.getUserId() + "";
    }

    @PostMapping("deleteUser")
    public String deleteUser(@RequestBody UserInfoReq req, HttpServletRequest request) {
        userDao.deleteUserInfo(req);
        return req.getUserId() + "";
    }

    @PostMapping("queryRole")
    public String queryRoleInfo(@RequestBody RoleInfoBean req, HttpServletRequest request) {
        List<RoleInfoBean> roleInfoBeans = userDao.selectRoleInfo(req);
        JSONArray jsonArray = new JSONArray(Collections.singletonList(roleInfoBeans));
        return jsonArray.toString();
    }

    @PostMapping("queryUserRoleInfo")
    public String queryUserRoleInfo(@RequestBody UserInfoReq req, HttpServletRequest request) {
        List<JSONObject> list = userDao.selectUserRoleInfo(req);
        return new JSONArray(Collections.singletonList(list)).toString();
    }
}
