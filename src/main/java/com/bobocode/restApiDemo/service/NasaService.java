package com.bobocode.restApiDemo.service;

import com.bobocode.restApiDemo.dto.Photos;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class NasaService {
    private final RestTemplate restTemplate;

    @Value("${apiKey}")
    private String apiKey;

    @Value("${urlTemplate}")
    private String urlTemplate;

    @Value("${env}")
    private String env;

    public NasaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getInfo(String sol) {
        System.out.println(env);
        URI uri = UriComponentsBuilder.fromHttpUrl(urlTemplate)
                .queryParam("sol", sol)
                .queryParam("api_key", apiKey)
                .build().toUri();
        ResponseEntity<Photos> forEntity = restTemplate.getForEntity(uri, Photos.class);
//        Photos forObject = restTemplate.getForObject(uri, Photos.class);
        Photos photos = forEntity.getBody();
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return photos.toString();
        }
        return "error";
    }
}
