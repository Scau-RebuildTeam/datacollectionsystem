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
    public long count(String value) {
        if (value.isEmpty()) {
            return repository.count();
        } else {
            return repository.findBySpiderLikeOrDateLikeOrTitleLike(value, value, value).size();
        }
    }

    @Override
    public List<Data> getData(int pageNum, int pageSize, String value) {
        if (value.isEmpty()) {
            return getAllData(pageNum, pageSize);
        } else {
            PageRequest pageRequest = PageRequest.of(pageNum, pageSize, Sort.by("date").descending());
            return repository.findBySpiderLikeOrDateLikeOrTitleLike(value, value, value, pageRequest);
        }
    }

    @Override
    public List<Data> getAllData(int pageNum, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, Sort.by("date").descending());
        return repository.findAll(pageRequest).getContent();
    }

    @Override
    public long count() {
        return 0;
    }
}
