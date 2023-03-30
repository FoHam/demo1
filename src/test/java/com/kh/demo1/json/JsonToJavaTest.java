package com.kh.demo1.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@Slf4j
public class JsonToJavaTest {
  @Test
  void test1() throws JsonProcessingException {
    String json = "{\n" +
        "    \"request_cnt\": 1,\n" +
        "    \"match_cnt\": 1,\n" +
        "    \"status_code\": \"OK\",\n" +
        "    \"data\": [\n" +
        "        {\n" +
        "            \"b_no\": \"6212002123\",\n" +
        "            \"b_stt\": \"계속사업자\",\n" +
        "            \"b_stt_cd\": \"01\",\n" +
        "            \"tax_type\": \"부가가치세 간이과세자\",\n" +
        "            \"tax_type_cd\": \"02\",\n" +
        "            \"end_dt\": \"\",\n" +
        "            \"utcc_yn\": \"N\",\n" +
        "            \"tax_type_change_dt\": \"20000701\",\n" +
        "            \"invoice_apply_dt\": \"\"\n" +
        "        }\n" +
        "    ]\n" +
        "}";

    ObjectMapper objectMapper = new ObjectMapper();
    Root root = objectMapper.readValue(json, Root.class);
    log.info("root={}",root);
    for( Root.Datum datum : root.getData()){
      log.info("사업자번호={}",datum.getB_no());
      datum.setB_no("111");
    }

    String jsonFormatString = objectMapper.writeValueAsString(root);
    log.info("jsonFormatString={}", jsonFormatString);
  }

  @Data  //toString(), getter(), setter(), equals(), hashCode()
  static class Root{
    private int request_cnt;
    private int match_cnt;
    private String status_code;
    private ArrayList<Datum> data;
    @Data
    static class Datum{
      private String b_no;
      private String b_stt;
      private String b_stt_cd;
      private String tax_type;
      private String tax_type_cd;
      private String end_dt;
      private String utcc_yn;
      private String tax_type_change_dt;
      private String invoice_apply_dt;
    }
  }

}
