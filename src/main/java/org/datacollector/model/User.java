package org.datacollector.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by 哲帆 on 2018.8.21.
 */
@Document(collection = "User")
public class User {

    private String userid;

    private String password;

    public User(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
