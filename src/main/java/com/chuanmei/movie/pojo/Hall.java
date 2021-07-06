package com.chuanmei.movie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hall {
  private int id;
  private String name;
  private String seats;
  private int status;
}
