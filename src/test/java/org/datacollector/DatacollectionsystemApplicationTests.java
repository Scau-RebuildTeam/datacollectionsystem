package org.datacollector;

import org.datacollector.dao.DataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatacollectionsystemApplicationTests {

    @Autowired
    private DataRepository dataRepository;

    @Test
    public void contextLoads() {
        String value = "2015";
        PageRequest pageRequest = PageRequest.of(0, 20, Sort.by("date").descending());
        System.out.println(dataRepository.findBySpiderLikeOrDateLikeOrTitleLike(value, value, value, pageRequest).size());
    }

}
