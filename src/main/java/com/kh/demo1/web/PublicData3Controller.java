package com.kh.demo1.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest")
public class PublicData3Controller {

  @GetMapping("/1")
  public String test1( @RequestBody  String json){
    log.info("json={}",json);
    return "ok";
  }
  @GetMapping("/2")
  public String test1(RequestEntity<String> entity){
    String json = entity.getBody();
    log.info("json={}",json);
    return "ok";
  }
}
