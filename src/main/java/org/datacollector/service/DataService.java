package org.datacollector.service;

import org.datacollector.model.Data;

import java.util.List;

/**
 * Created by 哲帆 on 2018.8.24.
 */
public interface DataService extends BaseNoSqlService<Data> {

    List<Data> getData(int pageNum, int pageSize, String value);

    List<Data> getAllData(int pageNum, int pageSize);

}
