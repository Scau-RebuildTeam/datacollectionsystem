package org.datacollector.service;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Created by 哲帆 on 2018.8.24.
 */
public interface BaseService<T> {
    void save(T model);//持久化

    void save(List<T> models);//批量持久化

    void deleteById(Object id);//通过主鍵刪除

    void deleteByIds(List<Object> idList);//批量刪除 eg：ids -> “1,2,3,4”

    void update(T model);//更新

    T findById(Object id);//通过ID查找

    T findBy(String property, Object value) throws TooManyResultsException; //通过某个成员属性查找,value需符合unique约束

    List<T> findByIds(List<Object> idList);//通过多个ID查找//eg：ids -> “1,2,3,4”

    List<T> findByCondition(Condition condition);//根据条件查找

    List<T> findAll();//获取所有
}
