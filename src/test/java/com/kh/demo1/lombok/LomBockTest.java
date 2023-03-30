package com.kh.demo1.lombok;

import lombok.*;
import org.junit.jupiter.api.Test;

public class LomBockTest {

  @Test
  void test(){
    Person p = new Person();
    Person p2 = new Person("홍길동",30);
//    Person p3 = new Person("한국");

    p2.setName("홍길순");
    p2.setAge(40);

    System.out.println(p2.getName());
    System.out.println(p2.getAge());

    System.out.println(p2);
    System.out.println(p2);
  }



  @NoArgsConstructor  //기본생성자를 만듦
  @AllArgsConstructor // 모든 멤버필드를 매개변수로하는 생성자를 만듦
  @Setter
  @Getter
  @ToString
  @EqualsAndHashCode
//  @RequiredArgsConstructor  // final 멤버필드를 매개변수로하는 생성자를 만듦
  static class Person {
//    private final String national;
    private String name;
    private int age;

//    Person(String national) {
//      this.national = national;
//    }
//    Person (){}
//    Person(String name, int age) {
//      this.name = name;
//      this.age = age;
//    }

//    public void setName(String name) {
//      this.name = name;
//    }
//
//    public void setAge(int age) {
//      this.age = age;
//    }

//    public String getName() {
//      return name;
//    }
//
//    public int getAge() {
//      return age;
//    }
  }
}
