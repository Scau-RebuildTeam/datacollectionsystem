package org.datacollector.dao;

import org.datacollector.model.Email;

public interface EmailMapper {
    int deleteByPrimaryKey(String address);

    int insert(Email record);

    int insertSelective(Email record);

    Email selectByPrimaryKey(String address);

    int updateByPrimaryKeySelective(Email record);

    int updateByPrimaryKey(Email record);
}