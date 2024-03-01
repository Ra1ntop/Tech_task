package com.tech.task_server.entity.user;


import com.tech.task_server.entity.type.RoleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin extends User {
    public Admin() {
        super();
        setRoleType(RoleType.ADMIN);
    }
}
