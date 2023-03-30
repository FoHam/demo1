package com.kh.demo1.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class JavaToJasonTest {
  @Test
  void test() throws JsonProcessingException {
    // 자바객체=>json포맷 문자열로 변환
    ObjectMapper objectMapper = new ObjectMapper();
    String p = objectMapper.writeValueAsString(new Person("홍길동", 30));
    System.out.println(p);

    //json포맷 문자열=>자바객체
    Person p2 = objectMapper.readValue(p,Person.class);
    System.out.println(p2);
  }

  @Test
  void test2() throws JsonProcessingException {
    PubData data = new PubData(new ArrayList<String>());
    data.getB_no().add("6212002123");

    ObjectMapper objectMapper = new ObjectMapper();
    String p = objectMapper.writeValueAsString(data);

    System.out.println(p);

    //json포맷 문자열=>자바객체
    PubData p2 = objectMapper.readValue(p,PubData.class);
    System.out.println(p2);
  }

//  @Data
  static class PubData{
    private ArrayList<String> b_no;
    private PubData(){}

    public PubData(ArrayList<String> b_no) {
      this.b_no = b_no;
    }

    public ArrayList<String> getB_no() {
      return b_no;
    }

    public void setB_no(ArrayList<String> b_no) {
      this.b_no = b_no;
    }
  }


  static class Person{
    private String name;
    private int age;

    public Person(){}

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setAge(int age) {
      this.age = age;
    }

    @Override
    public String toString() {
      return "Person{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }
}
