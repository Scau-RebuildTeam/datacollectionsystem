package org.datacollector.dao;

import org.datacollector.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by 哲帆 on 2018.8.21.
 */
public interface UserRepository extends MongoRepository<User, Object> {

    User findFirstByUserid(String userid);

}
