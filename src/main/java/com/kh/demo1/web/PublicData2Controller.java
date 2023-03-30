package com.kh.demo1.web;

import com.kh.demo1.svc.PublicData4;
import com.kh.demo1.web.api.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Slf4j   // log.info(),log.error(),log.debug(),log.trace(),log.warning()
@Controller
@RequestMapping("/pubData2")
@RequiredArgsConstructor
public class PublicData2Controller {

  private final PublicData4 publicData4;

  @GetMapping("/bn")
  public String businessNumberChk(){
    return "pub/businessNumberChk";
  }

  @GetMapping("/bn10")
  public String businessNumberChk10(){
    return "pub/businessNumberChk10";
  }

  @ResponseBody
  @PostMapping("/bn10")
  public ApiResponse<Object> businessNumberChk10_1(
      @RequestBody String businessNo  //"{"b_no": [ "0000000000"]}
  ){
    log.info("businessNo={}",businessNo);
    Map<String, String> publicData = publicData4.getPublicData(businessNo);
    //응답메세지
    ApiResponse<Object> response = ApiResponse.createApiResMsg("00","성공",publicData);
    log.info("publicData",publicData.toString());
    log.info("response",response.toString());
    return response;
  }
  @ResponseBody
  @PostMapping("/bn11")
  public String businessNumberChk11_1(
      @RequestBody String json  //{"b_no":"6108610288","start_dt":"1","p_nm":"1"}
  ){
    log.info("json={}",json);
    String res = publicData4.getPublicData2(json);

    return res;
  }







  @GetMapping("/bn2")
  public String businessNumberChk2(){
    return "pub/businessNumberChk2";
  }
  @GetMapping("/bn3")
  public String businessNumberChk3(){
    return "pub/businessNumberChk3";
  }
  @GetMapping("/bn4")
  public String businessNumberChk4(){
    return "pub/businessNumberChk4";
  }
  @GetMapping("/bn5")
  public String businessNumberChk5(){
    return "pub/businessNumberChk5";
  }

  //1) 쿼리파라미터
  @GetMapping("/bn2_1")
  public String businessNumberChk2_1(
      @RequestParam("businessNm") String businessNm,
      @RequestParam("name") String name
  ){

    log.info("businessNm={}", businessNm);
    log.info("name={}", name);
    return "pub/businessNumberChk2";
  }
  //2) url 경로
  @GetMapping("/bn3_1/{businessNm}/{name}")
  public String businessNumberChk3_1(
      @PathVariable("businessNm") String businessNm,
      @PathVariable("name") String name
  ){

    log.info("businessNm={}", businessNm);
    log.info("name={}", name);
    return "pub/businessNumberChk3";
  }

  //3) 요청메소드 바디
  @PostMapping("/bn4_1")
  public String businessNumberChk4_1(
      @RequestParam("businessNm") String businessNm,
      @RequestParam("name") String name
  ){

    log.info("businessNm={}", businessNm);
    log.info("name={}", name);
    return "pub/businessNumberChk4";
  }
  //4) 요청메소드 헤더
  @PostMapping("/bn5_1")
  public String businessNumberChk5_1(
      @RequestHeader("businessNm") String businessNm,
      @RequestHeader("name") String name
  ) throws UnsupportedEncodingException {

    log.info("businessNm={}", URLDecoder.decode(businessNm,"utf-8"));
    log.info("name={}", URLDecoder.decode(name,"utf-8"));
    return "pub/businessNumberChk5";
  }
}
