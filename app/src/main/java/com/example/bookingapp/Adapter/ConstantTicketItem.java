package com.example.bookingapp.Adapter;

import java.util.ArrayList;

public class ConstantTicketItem {
    public static ArrayList<TicketItem> getTicketItem() {
        ArrayList<TicketItem> ticketList = new ArrayList<>();

        // Flights for each day from 6th July to 15th July with intervals of 4 hours
        ticketList.add(new TicketItem("06 Jul", "9:00 AM", "$50", "VJ-001"));
        ticketList.add(new TicketItem("06 Jul", "1:00 PM", "$55", "VJ-002"));
        ticketList.add(new TicketItem("06 Jul", "5:00 PM", "$70", "VN-001"));
        ticketList.add(new TicketItem("06 Jul", "9:00 PM", "$75", "VN-002"));

        ticketList.add(new TicketItem("07 Jul", "9:00 AM", "$80", "VJ-003"));
        ticketList.add(new TicketItem("07 Jul", "1:00 PM", "$85", "VJ-004"));
        ticketList.add(new TicketItem("07 Jul", "5:00 PM", "$90", "VN-003"));
        ticketList.add(new TicketItem("07 Jul", "9:00 PM", "$95", "VN-004"));

        ticketList.add(new TicketItem("08 Jul", "9:00 AM", "$100", "VJ-005"));
        ticketList.add(new TicketItem("08 Jul", "1:00 PM", "$105", "VJ-006"));
        ticketList.add(new TicketItem("08 Jul", "5:00 PM", "$110", "VN-005"));
        ticketList.add(new TicketItem("08 Jul", "9:00 PM", "$115", "VN-006"));

        ticketList.add(new TicketItem("09 Jul", "9:00 AM", "$120", "VJ-007"));
        ticketList.add(new TicketItem("09 Jul", "1:00 PM", "$125", "VJ-008"));
        ticketList.add(new TicketItem("09 Jul", "5:00 PM", "$130", "VN-007"));
        ticketList.add(new TicketItem("09 Jul", "9:00 PM", "$135", "VN-008"));

        ticketList.add(new TicketItem("10 Jul", "9:00 AM", "$140", "VJ-009"));
        ticketList.add(new TicketItem("10 Jul", "1:00 PM", "$145", "VJ-010"));
        ticketList.add(new TicketItem("10 Jul", "5:00 PM", "$150", "VN-009"));
        ticketList.add(new TicketItem("10 Jul", "9:00 PM", "$155", "VN-010"));

        ticketList.add(new TicketItem("11 Jul", "9:00 AM", "$160", "VJ-011"));
        ticketList.add(new TicketItem("11 Jul", "1:00 PM", "$165", "VJ-012"));
        ticketList.add(new TicketItem("11 Jul", "5:00 PM", "$170", "VN-011"));
        ticketList.add(new TicketItem("11 Jul", "9:00 PM", "$175", "VN-012"));

        ticketList.add(new TicketItem("12 Jul", "9:00 AM", "$180", "VJ-013"));
        ticketList.add(new TicketItem("12 Jul", "1:00 PM", "$185", "VJ-014"));
        ticketList.add(new TicketItem("12 Jul", "5:00 PM", "$190", "VN-013"));
        ticketList.add(new TicketItem("12 Jul", "9:00 PM", "$195", "VN-014"));

        ticketList.add(new TicketItem("13 Jul", "9:00 AM", "$200", "VJ-015"));
        ticketList.add(new TicketItem("13 Jul", "1:00 PM", "$205", "VJ-016"));
        ticketList.add(new TicketItem("13 Jul", "5:00 PM", "$210", "VN-015"));
        ticketList.add(new TicketItem("13 Jul", "9:00 PM", "$215", "VN-016"));

        ticketList.add(new TicketItem("14 Jul", "9:00 AM", "$220", "VJ-017"));
        ticketList.add(new TicketItem("14 Jul", "1:00 PM", "$225", "VJ-018"));
        ticketList.add(new TicketItem("14 Jul", "5:00 PM", "$230", "VN-017"));
        ticketList.add(new TicketItem("14 Jul", "9:00 PM", "$235", "VN-018"));

        ticketList.add(new TicketItem("15 Jul", "9:00 AM", "$240", "VJ-019"));
        ticketList.add(new TicketItem("15 Jul", "1:00 PM", "$245", "VJ-020"));
        ticketList.add(new TicketItem("15 Jul", "5:00 PM", "$250", "VN-019"));
        ticketList.add(new TicketItem("15 Jul", "9:00 PM", "$255", "VN-020"));

        return ticketList;
    }
}
