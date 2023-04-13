package com.mysql.signaldb.dao;

import com.alibaba.fastjson.JSONObject;
import com.mysql.signaldb.entity.RoleInfoBean;
import com.mysql.signaldb.entity.UserInfoReq;
import com.mysql.signaldb.entity.UserQueryBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author HCW
 * @date 2023/4/13 14:01
 * @todo
 */
@Mapper
public interface UserDao {
    List<UserQueryBean> selectUserInfo(UserQueryBean userQueryBean);

    int insertUserInfo(UserInfoReq req);

    int updateUserInfo(UserInfoReq req);

    int deleteUserInfo(UserInfoReq req);

    List<RoleInfoBean> selectRoleInfo(RoleInfoBean req);

    List<JSONObject> selectUserRoleInfo(UserInfoReq req);
}
