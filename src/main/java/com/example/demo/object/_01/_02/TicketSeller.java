package com.example.demo.object._01._02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TicketSeller {

  private TicketOffice ticketOffice;

  public TicketSeller(TicketOffice ticketOffice) {
    this.ticketOffice = ticketOffice;
  }

  public TicketOffice getTicketOffice() {
    return ticketOffice;
  }

  public void sellTo(Audience audience) {
    ticketOffice.sellTicketTo(audience);
  }

}
