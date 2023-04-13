package com.mysql.signaldb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author HCW
 * @date 2023/4/13 14:50
 * @todo
 */
@Data
@NoArgsConstructor
@ToString
public class UserInfoReq {
    private Long userId;
    private String password;
    private String userName;

    private String description;

    private String phoneNumber;

    private String email;
}
