package com.kh.demo1.svc.dto;

import lombok.Data;

import java.util.ArrayList;
@Data
public class BusinessStatusChk {
  private int request_cnt;
  private int match_cnt;
  private String status_code;
  private ArrayList<Status> data;
  @Data
  public static class Status{
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
