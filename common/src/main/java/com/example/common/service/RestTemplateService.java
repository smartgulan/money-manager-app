package com.example.common.service;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateService {

    public <T> T send(
            String url,
            String token,
            Class body,
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
