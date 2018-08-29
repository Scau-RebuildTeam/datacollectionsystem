package org.datacollector.service.impl;

import org.datacollector.dao.DataRepository;
import org.datacollector.model.Data;
import org.datacollector.service.DataService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 哲帆 on 2018.8.24.
 */
@Service
public class DataServiceImpl implements DataService {

    @Resource
    private DataRepository repository;

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public List<Data> getData(int pageNum, int pageSize, String value) {
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize, Sort.by("date"));
        if (value.isEmpty()) {
            return getAllData(pageNum, pageSize);
        } else {
            return repository.findBySpiderOrDateOrTitle(value, value, value, pageRequest);
        }
    }

    @Override
    public List<Data> getAllData(int pageNum, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize, Sort.by("date"));
        return repository.findAll(pageRequest).getContent();
    }
}
