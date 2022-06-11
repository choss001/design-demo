package com.example.demo.object._01_._01;

public class Client {
  public static void main(String[] args) {
    TicketOffice ticketOffice = new TicketOffice();
    TicketSeller ticketSeller = new TicketSeller(ticketOffice);
    Theater theater = new Theater(ticketSeller);
  }
}
