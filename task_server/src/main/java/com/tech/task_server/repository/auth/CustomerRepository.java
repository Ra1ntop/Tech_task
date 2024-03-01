package com.tech.task_server.repository.auth;

import com.tech.task_server.entity.user.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends UserRepository<Customer> {

}
