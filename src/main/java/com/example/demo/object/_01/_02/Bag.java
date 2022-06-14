package com.example.demo.object._01._02;

public class Bag {

  public Bag(long amount) {
    this(null, amount);
  }

  public Bag(Invitation inviation, long amount) {
    this.invitation = inviation;
    this.amount = amount;
  }
  private Long amount;
  private Invitation invitation;
  private Ticket ticket;

  public boolean hasInvitation() {
    return ticket != null;
  }

  public Long hold(Ticket ticket){
    if (hasInvitation()) {
     setTicket(ticket);
     return 0L;
    }else{
      setTicket(ticket);
      minusAmount(ticket.getFee());
      return ticket.getFee();
    }
  }

  private boolean hasTicket() {
    return ticket != null;
  }

  private void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  private void minusAmount(Long amount) {
    this.amount -= amount;
  }

  private void plusAmount(long amount) {
    this.amount += amount;
  }
}
