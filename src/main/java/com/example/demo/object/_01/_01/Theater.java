package com.example.demo.object._01._01;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Theater {
  private TicketSeller ticketSeller;

  public Theater(TicketSeller ticketSeller) {
    this.ticketSeller = ticketSeller;
  }

  public void enter(Audience audience){
    log.info("Theater -> enter audience : {}", audience);
    if (audience.getBag().hasInvitation()) {
      log.info("audience has inviatation");
      Ticket ticket = ticketSeller.getTicketOffice().getTicket();
      audience.getBag().setTicket(ticket);
    }else{
      log.info("audience has not inviatation");
      Ticket ticket = ticketSeller.getTicketOffice().getTicket();
      audience.getBag().minusAmount(ticket.getFee());
      ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
      audience.getBag().setTicket(ticket);
    }
  }
}
