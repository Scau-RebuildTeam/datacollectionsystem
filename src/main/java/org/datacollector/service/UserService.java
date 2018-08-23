package org.datacollector.service;

import org.datacollector.model.User;

/**
 * Created by 哲帆 on 2018.8.24.
 */
public interface UserService extends BaseService<User> {

    void login(String userid, String password);

    void login(String password);

    void signUp(String userid, String password);

}
