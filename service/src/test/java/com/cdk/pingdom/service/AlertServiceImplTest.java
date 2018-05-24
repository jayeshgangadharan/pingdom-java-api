package com.cdk.pingdom.service;

import com.cdk.pingdom.dto.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Jayesh on 5/10/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AlertServiceImplTest.Config.class)
@TestPropertySource(locations = {"classpath:pingdom.properties"})
public class AlertServiceImplTest {

    public static final Long SOME_RANDOM_CHECKID = 12345L;
    public static final String SOME_RANDOM_USERIDS = "12345";

    public static Logger LOGGER = LoggerFactory.getLogger(AlertServiceImplTest.class);

    @Resource
    private AlertService alertService;

    @Before
    public void setup() {

    }

    @Test
    public void testFindAllChecks() throws Exception {
        Checks checks = alertService.findAllChecks();

        for(Check check : checks.getChecks()) {
            System.out.println(check.getId().toString()+","+check.getName());
        }
        assertNotNull(checks);
    }

    @Test
    public void testGetCheckDetail() throws Exception {
        Check check = alertService.getCheckDetail(12345L);
        assertNotNull(check);
        assertNotNull(check.getId());
    }


    @Test
    public void testAddUserToCheck() throws Exception {
        alertService.addUserToCheck(SOME_RANDOM_CHECKID, SOME_RANDOM_USERIDS);
    }

    @Test
    @Ignore("Run on demand")
    public void testAddUserToAllChecks() throws Exception {
        Checks checks = alertService.findAllChecks();
        for(Check check : checks.getChecks()) {
            alertService.addUserToCheck(check.getId(), "12345L");
        }
    }

    @Test
    @Ignore("Run on demand")
    public void testAddContact() throws Exception {
        UserResponse userResponse = alertService.addContact("Jayesh", "Jayesh@cdk.com");

        assertNotNull(userResponse);
        assertNotNull(userResponse.getUser().getId());
    }

    @Test
    public void testFindAllUsers() throws Exception {
        UserListResponse users = alertService.findAllUsers();

        for(User user : users.getUsers()) {
            System.out.println(user.getId().toString()+","+user.getName());
        }
        assertNotNull(users);
    }


    @Configuration
    public static class Config {

        @Bean
        public static PropertySourcesPlaceholderConfigurer propertiesResolver() {
            return new PropertySourcesPlaceholderConfigurer();
        }

        @Bean
        public PingdomConfiguration pingdomConfiguration() {
            return new PingdomConfiguration();
        }

        @Bean
        public AlertService alertService() {
            return new AlertServiceImpl();
        }
    }
}
