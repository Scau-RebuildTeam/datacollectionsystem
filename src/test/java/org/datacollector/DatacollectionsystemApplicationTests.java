package org.datacollector;

import org.datacollector.service.DataService;
import org.datacollector.service.EmailService;
import org.datacollector.service.SpiderManagementService;
import org.datacollector.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatacollectionsystemApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private SpiderManagementService spiderManagementService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private DataService dataService;

    @Test
    public void contextLoads() {
        System.out.println(userService.login("admin"));
        System.out.println(spiderManagementService.count());
        System.out.println(emailService.findAll(0, 20).get(0).getAddress());
        System.out.println(dataService.getAllData(1, 10).size());
        System.out.println(dataService.getAllData(1, 10).get(1).getTitle());
    }

}
