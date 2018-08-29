package org.datacollector.service;

import java.util.List;

/**
 * Created by 哲帆 on 2018.8.24.
 */
public interface BaseSqlService<T> {

    long count();

    boolean save(T model);//持久化

    boolean deleteById(Object id);//通过主鍵刪除

    List<T> find(String value);

    List<T> findAll();//获取所有
}
