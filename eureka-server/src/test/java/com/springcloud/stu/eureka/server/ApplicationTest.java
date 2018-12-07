package com.springcloud.stu.eureka.server;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

/**
 * Created by mengtian on 2018/12/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class ApplicationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void catalogLoads() {
        ResponseEntity<Map> entity = testRestTemplate.getForEntity("/eureka-server/app", Map.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
}
