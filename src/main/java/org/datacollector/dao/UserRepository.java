package org.datacollector.dao;

import org.datacollector.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by 哲帆 on 2018.8.21.
 */
public interface UserRepository extends MongoRepository<User, Object>, PagingAndSortingRepository<User, Object> {

    User findFirstByUseridAndPassword(String userid, String password);

    User findFirstByPassword(String password);

}
