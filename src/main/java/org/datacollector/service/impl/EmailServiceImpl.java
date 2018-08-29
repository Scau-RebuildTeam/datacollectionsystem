package org.datacollector.service.impl;

import com.github.pagehelper.PageHelper;
import org.datacollector.mappers.EmailMapper;
import org.datacollector.model.Email;
import org.datacollector.service.EmailService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 哲帆 on 2018.8.24.
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    private EmailMapper emailMapper;

    @Override
    public long count() {
        return emailMapper.selectAll().size();
    }

    @Override
    public boolean save(Email model) {
        if (emailMapper.insert(model) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteById(Object id) {
        if (emailMapper.deleteByPrimaryKey(id) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Deprecated
    public List<Email> find(String value) {
        return null;
    }

    @Override
    @Deprecated
    public List<Email> findAll() {
        return findAll(0, 1000);
    }

    @Override
    public List<Email> find(int pageNum, int pageSize, String value) {
        Example example = new Example(Email.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orEqualTo("address", value).orEqualTo("name", value);
        PageHelper.startPage(pageNum, pageSize);
        return emailMapper.selectByExample(example);
    }

    @Override
    public List<Email> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return emailMapper.selectAll();
    }
}
