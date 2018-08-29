package org.datacollector.service.impl;

import org.datacollector.dao.UserRepository;
import org.datacollector.model.User;
import org.datacollector.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 哲帆 on 2018.8.24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository repository;

    @Override
    public boolean login(String userid, String password) {
        if (repository.findFirstByUseridAndPassword(userid, password) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean login(String password) {
        if (repository.findFirstByPassword(password) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void signUp(String userid, String password) {
        repository.insert(new User(userid, password));
    }

    @Override
    public long count() {
        return repository.count();
    }
}
