package com.example.demo.object._01._01;

import java.util.Arrays;
import java.util.List;

public class Client {
  public static void main(String[] args) {
    Invitation invitation = new Invitation();
    Bag bag = new Bag(invitation, 2000L);
    Audience audience = new Audience(bag);
    Ticket ticket1 = Ticket.builder().fee(5000L).build();
    Ticket ticket2 =Ticket.builder().fee(5000L).build();
    Ticket ticket3 =Ticket.builder().fee(5000L).build();
    List<Ticket> tickets = Arrays.asList(Ticket.builder().fee(5000L).build(),
            Ticket.builder().fee(8000L).build(),
            Ticket.builder().fee(7000L).build());
    TicketOffice ticketOffice = new TicketOffice(3000L,ticket1, ticket2);
    TicketSeller ticketSeller = new TicketSeller(ticketOffice);
    Theater theater = new Theater(ticketSeller);
    theater.enter(audience);
  }
}
