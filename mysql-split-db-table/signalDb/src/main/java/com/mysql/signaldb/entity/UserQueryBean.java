package com.mysql.signaldb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UserQueryBean {

    private String userName;

    private String description;

    private String phoneNumber;

    private String email;

}