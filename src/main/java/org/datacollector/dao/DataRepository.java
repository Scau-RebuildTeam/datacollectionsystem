package org.datacollector.dao;

import org.datacollector.model.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by 哲帆 on 2018.8.21.
 */
public interface DataRepository extends PagingAndSortingRepository<Data, Object> {

    List<Data> findBySpiderLikeOrDateLikeOrTitleLike(String spider, String date, String title, Pageable pageable);

    List<Data> findBySpiderLikeOrDateLikeOrTitleLike(String spider, String date, String title);

}
