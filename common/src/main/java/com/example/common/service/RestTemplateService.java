package com.example.common.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class RestTemplateService {

    public <T, R> T send(
            String url,
            String token,
            R body,
            Class<T> classType
    ) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<?> entity = new HttpEntity<>(body, headers);

        if (body != null) {
            return restTemplate.exchange(url, HttpMethod.POST, entity, classType).getBody();
        }
        return restTemplate.exchange(url, HttpMethod.GET, entity, classType).getBody();
    }

}
