package com.kh.demo1.svc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

@Slf4j
@Service
public class PublicData3 {
  //    public String getPublicData() {
//      try {
  public static void main(String[] args) throws IOException, URISyntaxException {
    final String SERVICE_KEY = "bJ0AcEWnYARdHMe24EsPd77ralP%2BiRWLuhIeWgoIBgM%2F4dqlAgbS%2FilwgSiZkbkL9ojCBQHuEZI2TtoMqYzRhA%3D%3D";
    UriComponents complexUrl = UriComponentsBuilder
        .fromUriString("http://apis.data.go.kr/6260000/FoodService/getFoodKr")
//        .uriVariables(Map.of("nickname", "dailycode"))
        .queryParam("serviceKey", SERVICE_KEY)
        .queryParam("pageNo", "1")
        .queryParam("numOfRows", "10")
        .queryParam("resultType", "json")
        .build();

    // request url
    String url = complexUrl.toString();

    // create an instance of RestTemplate
    RestTemplate restTemplate = new RestTemplate();

    // create headers
    HttpHeaders headers = new HttpHeaders();

    // set `Content-Type` and `Accept` headers
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    // build the request
    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);

    // make an HTTP GET request with headers
    ResponseEntity<String> response = restTemplate.exchange(
        new URI(url),
        HttpMethod.GET,
        request,
        String.class
    );

    // check response
    if (response.getStatusCode() == HttpStatus.OK) {
      log.info("Request Successful={}",response.getBody());
    } else {
      log.info("Request Failed={}",response.getStatusCode());
    }
  }
}
