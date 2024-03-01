package com.tech.task_server.entity.user;


import com.tech.task_server.entity.type.RoleType;

public class Customer extends User {

    public Customer() {
        super();
        setRoleType(RoleType.CUSTOMER);
    }
}
