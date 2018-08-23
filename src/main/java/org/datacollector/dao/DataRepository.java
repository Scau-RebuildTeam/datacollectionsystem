package org.datacollector.dao;

import org.datacollector.model.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by 哲帆 on 2018.8.21.
 */
public interface DataRepository extends MongoRepository<Data, Object> {

    List<Data> findBySpider(String spider);

    List<Data> findByDate(String date);

    List<Data> findByTitle(String date);

}
