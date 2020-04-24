package com.oyzl.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfo {
  private String userName;
  private String address;
  private String phone;
  private String company;
}
