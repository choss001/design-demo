package com.example.demo.object._01._01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
  private Long fee;
  public Long getFee(){
    return fee;
  }

  public void setFee(Long fee) {
    this.fee = fee;
  }
}
