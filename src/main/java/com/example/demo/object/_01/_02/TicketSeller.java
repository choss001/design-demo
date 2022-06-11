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
    if (audience.getBag().hasInvitation()) {
      log.info("audience has inviatation");
      Ticket ticket = getTicketOffice().getTicket();
      audience.getBag().setTicket(ticket);
    }else{
      log.info("audience has not inviatation");
      Ticket ticket = getTicketOffice().getTicket();
      audience.getBag().minusAmount(ticket.getFee());
      getTicketOffice().plusAmount(ticket.getFee());
      audience.getBag().setTicket(ticket);
    }

  }

}
