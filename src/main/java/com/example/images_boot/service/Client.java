package com.example.images_boot.service;

import com.example.images_boot.model.Site;
import com.example.images_boot.model.SitesDto;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class Client {
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    public List<Site> getSites() throws URISyntaxException {
        String url = "https://api.stackexchange.com/2.3/sites?page=1&pagesize=9999&filter=!FmdZhk)Fm47clKEWzoBErb3Z2S";
        SitesDto response = null;
        try {
            response = restTemplate.getForObject(new URI(url), SitesDto.class);
            return response != null ? response.getItems() : null;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
