package com.example.demo.object._01._01;

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

  public boolean hasTicket() {
    return ticket != null;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public void minusAmount(Long amount) {
    this.amount -= amount;
  }

  public void plusAmount(long amount) {
    this.amount += amount;
  }
}
