package com.wujun.boot.repository;

import com.wujun.boot.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author wujun
 * @description
 * @date 18/2/8.
 */
public interface UserRepository extends MongoRepository<User,Long> {
    User findByUsername(String username);
}
