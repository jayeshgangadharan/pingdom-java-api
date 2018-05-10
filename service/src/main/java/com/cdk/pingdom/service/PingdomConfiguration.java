package com.cdk.pingdom.service;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jayesh on 5/10/18.
 */
@Configuration
@PropertySource("classpath:pingdom.properties")
public class PingdomConfiguration {

    @Value("${pingdom.application.key}")
    private String applicationKey;

    @Value("${pingdom.url:https://api.pingdom.com/api/2.0}")
    private String pingdomUrl;

    @Value("${pingdom.credentials}")
    private String credentials;

    @Value("${pingdom.admin.user}")
    private String adminUser;

    private RestTemplate restTemplate;

    public HttpEntity getHttpEntity() {
        byte[] plainCredsBytes = credentials.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", "Basic " + base64Creds);
        headers.add("app-key", applicationKey);
        headers.add("account-email", adminUser);

        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
        return httpEntity;
    }

    public RestTemplate getRestTemplate() {
        if(restTemplate == null) {
            restTemplate = new RestTemplate();
            List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
            messageConverters.add(converter);
            restTemplate.setMessageConverters(messageConverters);
        }
        return restTemplate;

    }

    public String getPingdomUrl() {
        return pingdomUrl;
    }

    public void setPingdomUrl(String pingdomUrl) {
        this.pingdomUrl = pingdomUrl;
    }

}
