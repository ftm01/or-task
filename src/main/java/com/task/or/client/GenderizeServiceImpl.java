package com.task.or.client;

import com.task.or.web.v1.dtos.genderize.GenderizeDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@Service
public class GenderizeServiceImpl implements GenderizeService {

    private final static String baseUrl = "https://api.genderize.io";

    private final RestTemplate restTemplate;

    @Autowired
    public GenderizeServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public GenderizeDataDTO getGender(String name) {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl).path("/").query("name={keyword}").buildAndExpand(name.toLowerCase()).toUri();
        ResponseEntity<GenderizeDataDTO> genderizeDataDTO = restTemplate.getForEntity(uri, GenderizeDataDTO.class);
        return Objects.requireNonNull(genderizeDataDTO.getBody(), "Data must not be null");
    }
}
