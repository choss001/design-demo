package com.example.demo.object._01._02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Theater {
  private TicketSeller ticketSeller;

  public Theater(TicketSeller ticketSeller) {
    this.ticketSeller = ticketSeller;
  }

  public void enter(Audience audience){
    ticketSeller.sellTo(audience);
  }
}
