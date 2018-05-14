package com.cdk.pingdom.service;

import com.cdk.pingdom.dto.Check;
import com.cdk.pingdom.dto.Checks;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Resource
    private AlertService alertService;

    @Before
    public void setup() {

    }

    @Test
    public void testFindAllChecks() {
        Checks checks = alertService.findAllChecks();
        assertNotNull(checks);
    }

    @Test
    public void testGetCheckDetail() {
        Check check = alertService.getCheckDetail(1982245);
        assertNotNull(check);
        assertNotNull(check.getId());
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
