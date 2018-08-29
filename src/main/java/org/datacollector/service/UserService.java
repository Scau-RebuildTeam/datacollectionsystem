package org.datacollector.service;

import org.datacollector.model.User;

/**
 * Created by 哲帆 on 2018.8.24.
 */
public interface UserService extends BaseNoSqlService<User> {

    boolean login(String userid, String password);

    boolean login(String password);

    void signUp(String userid, String password);

}
