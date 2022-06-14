package com.example.demo.discount;

import com.example.demo.member.Member;
import com.example.demo.object._01._03.Money;
import com.example.demo.object._01._03.Screening;

public interface DiscountPolicy {

  /**
   * @return 할인 금액
   */
  int discount(Member member, int price);
}
