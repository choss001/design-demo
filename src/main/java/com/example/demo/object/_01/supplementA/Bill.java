package com.example.demo.object._01.supplementA;

public class Bill {
  private Phone phone;
  private Money fee;

  public Bill(Phone phone, Money fee) {
    if (phone == null) {
      throw new IllegalArgumentException();
    }

    if (fee.isLessThen(Money.ZERO)) {
      throw new IllegalArgumentException();
    }

    this.phone = phone;
    this.fee = fee;
  }
}
