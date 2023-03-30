package com.kh.demo1.svc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Slf4j
@Service
public class PublicData2 {
  //    public String getPublicData() {
//      try {
  public static void main(String[] args) throws IOException {
    final String SERVICE_KEY = "bJ0AcEWnYARdHMe24EsPd77ralP%2BiRWLuhIeWgoIBgM%2F4dqlAgbS%2FilwgSiZkbkL9ojCBQHuEZI2TtoMqYzRhA%3D%3D";
    StringBuilder urlBuilder = new StringBuilder("http://api.odcloud.kr/api/nts-businessman/v1/status"); /*URL*/
    urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + SERVICE_KEY); /*Service Key*/
    urlBuilder.append("&" + URLEncoder.encode("resultType", "UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*JSON방식으로 호출 시 파라미터 resultType=json 입력*/

    URL url = new URL(urlBuilder.toString());
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-type", "application/json");
    conn.setRequestProperty("Accept", "application/json");

    //PayLoad 요청데이터 바디내용
    conn.setDoOutput(true);
    OutputStream os = conn.getOutputStream();
    os.write("{ \"b_no\": [\"6212002123\"]}".getBytes());
    os.flush();
    os.close();

    log.info("Response code: {}" ,conn.getResponseCode());
    BufferedReader rd;
    if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
      rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    } else {
      rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
    }
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
      sb.append(line);
    }
    rd.close();
    conn.disconnect();
    log.info("result={}",sb.toString());
//        return sb.toString();

//      } catch (Exception e) {
//        e.printStackTrace();
//      }
//      return null;
  }
}
