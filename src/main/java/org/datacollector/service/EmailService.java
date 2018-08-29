package org.datacollector.service;

import org.datacollector.model.Email;

import java.util.List;

/**
 * Created by 哲帆 on 2018.8.24.
 */
public interface EmailService extends BaseSqlService<Email> {


    List<Email> find(int pageNum, int pageSize, String value);

    List<Email> findAll(int pageNum, int pageSize);
}
