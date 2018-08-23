package org.datacollector;

import org.datacollector.dao.DataRepository;
import org.datacollector.dao.UserRepository;
import org.datacollector.mappers.EmailMapper;
import org.datacollector.mappers.SpiderMapper;
import org.datacollector.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatacollectionsystemApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private EmailMapper emailMapper;

    @Autowired
    private SpiderMapper spiderMapper;

    @Test
    public void contextLoads() {
        List<User> list = userRepository.findAll();
        System.out.println(list.size());
        System.out.println(list.get(0).getPassword());
        System.out.println(dataRepository.findBySpider("国家基金").get(0).getTitle());
        System.out.println(emailMapper.selectByPrimaryKey("c").getAddress());
        System.out.println(spiderMapper.selectByPrimaryKey("c").getDate1());
    }

}
