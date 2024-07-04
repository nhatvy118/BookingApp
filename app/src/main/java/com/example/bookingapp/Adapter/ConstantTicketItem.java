package com.example.bookingapp.Adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ConstantTicketItem {

    public static ArrayList<TicketItem> getTicketItem() {
        ArrayList<TicketItem> ticketList = new ArrayList<>();

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "8:00 AM",         // Departure time
                "$25",             // Price
                "FL123",            // Flight number
                "Da Nang",         // From city
                "Ho Chi Minh",      // To city
                "DNA",              // From airport code
                "SGN",              // To airport code
                "Jul 04",       // Date
                "Da Nang (DNA)", // From airport
                "Ho Chi Minh (SGN)"       // To airport
        ));
        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "9:00 AM",         // Departure time
                "$50",             // Price
                "VJ123",            // Flight number
                "Ho Chi Minh",         // From city
                "Da Nang",      // To city
                "SGN",              // From airport code
                "DNA",              // To airport code
                "Jul 04",       // Date
                "Ho Chi Minh (SGN)", // From airport
                "Da Nang (DNA)"       // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "4:00 PM",         // Departure time
                "$70",             // Price
                "VNA45",            // Flight number
                "Ho Chi Minh",         // From city
                "Hue",      // To city
                "SGN",              // From airport code
                "HUI",              // To airport code
                "Jul 04",       // Date
                "Ho Chi Minh (SGN)", // From airport
                "Hue (HUI)"       // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "8:00 PM",         // Departure time
                "$60",             // Price
                "VJ45",            // Flight number
                "Ho Chi Minh",         // From city
                "Da Nang",      // To city
                "SGN",              // From airport code
                "DNA",              // To airport code
                "Jul 04",       // Date
                "Ho Chi Minh (SGN)", // From airport
                "Da Nang (DNA)"       // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 05, 2024", // DateTime
                "2:15 PM",       // Departure time
                "$55",           // Price
                "FL789",         // Flight number
                "Ho Chi Minh",       // From city
                "Da Nang",   // To city
                "SGN",           // From airport code
                "DNA",           // To airport code
                "Jul 06",        // Date
                "Ho Chi Minh (SGN)", // From airport
                "Da Nang (DNA)" // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "10:00 AM",      // Departure time
                "$30",           // Price
                "VN101",         // Flight number
                "Ho Chi Minh",   // From city
                "Da Nang",       // To city
                "SGN",           // From airport code
                "DNA",           // To airport code
                "Jul 04",        // Date
                "Ho Chi Minh (SGN)", // From airport
                "Da Nang (DNA)"      // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "12:00 PM",      // Departure time
                "$35",           // Price
                "FL202",         // Flight number
                "Da Nang",       // From city
                "Ho Chi Minh",   // To city
                "DNA",           // From airport code
                "SGN",           // To airport code
                "Jul 04",        // Date
                "Da Nang (DNA)", // From airport
                "Ho Chi Minh (SGN)" // To airport
        ));
        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "2:30 PM",       // Departure time
                "$40",           // Price
                "VJ303",         // Flight number
                "Ho Chi Minh",   // From city
                "Da Nang",       // To city
                "SGN",           // From airport code
                "DNA",           // To airport code
                "Jul 04",        // Date
                "Ho Chi Minh (SGN)", // From airport
                "Da Nang (DNA)"      // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "4:30 PM",       // Departure time
                "$45",           // Price
                "FL404",         // Flight number
                "Da Nang",       // From city
                "Ho Chi Minh",   // To city
                "DNA",           // From airport code
                "SGN",           // To airport code
                "Jul 04",        // Date
                "Da Nang (DNA)", // From airport
                "Ho Chi Minh (SGN)" // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "6:00 PM",       // Departure time
                "$38",           // Price
                "VN505",         // Flight number
                "Ho Chi Minh",   // From city
                "Da Nang",       // To city
                "SGN",           // From airport code
                "DNA",           // To airport code
                "Jul 04",        // Date
                "Ho Chi Minh (SGN)", // From airport
                "Da Nang (DNA)"      // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "8:00 PM",       // Departure time
                "$39",           // Price
                "VJ606",         // Flight number
                "Da Nang",       // From city
                "Ho Chi Minh",   // To city
                "DNA",           // From airport code
                "SGN",           // To airport code
                "Jul 04",        // Date
                "Da Nang (DNA)", // From airport
                "Ho Chi Minh (SGN)" // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "7:00 AM",       // Departure time
                "$42",           // Price
                "FL707",         // Flight number
                "Ho Chi Minh",   // From city
                "Da Nang",       // To city
                "SGN",           // From airport code
                "DNA",           // To airport code
                "Jul 04",        // Date
                "Ho Chi Minh (SGN)", // From airport
                "Da Nang (DNA)"      // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "9:30 AM",       // Departure time
                "$43",           // Price
                "VJ808",         // Flight number
                "Da Nang",       // From city
                "Ho Chi Minh",   // To city
                "DNA",           // From airport code
                "SGN",           // To airport code
                "Jul 04",        // Date
                "Da Nang (DNA)", // From airport
                "Ho Chi Minh (SGN)" // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "11:00 AM",      // Departure time
                "$41",           // Price
                "VN909",         // Flight number
                "Ho Chi Minh",   // From city
                "Da Nang",       // To city
                "SGN",           // From airport code
                "DNA",           // To airport code
                "Jul 04",        // Date
                "Ho Chi Minh (SGN)", // From airport
                "Da Nang (DNA)"      // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "1:30 PM",       // Departure time
                "$44",           // Price
                "FL1010",        // Flight number
                "Da Nang",       // From city
                "Ho Chi Minh",   // To city
                "DNA",           // From airport code
                "SGN",           // To airport code
                "Jul 04",        // Date
                "Da Nang (DNA)", // From airport
                "Ho Chi Minh (SGN)" // To airport
        ));
        // July 04, 2024
        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "8:00 AM",       // Departure time
                "$25",           // Price
                "FL123",         // Flight number
                "Da Nang",       // From city
                "Ho Chi Minh",   // To city
                "DNA",           // From airport code
                "SGN",           // To airport code
                "Jul 04",        // Date
                "Da Nang (DNA)", // From airport
                "Ho Chi Minh (SGN)" // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 04, 2024", // DateTime
                "9:00 AM",       // Departure time
                "$50",           // Price
                "VJ123",         // Flight number
                "Ho Chi Minh",   // From city
                "Da Nang",       // To city
                "SGN",           // From airport code
                "DNA",           // To airport code
                "Jul 04",        // Date
                "Ho Chi Minh (SGN)", // From airport
                "Da Nang (DNA)"      // To airport
        ));

        // July 05, 2024
        ticketList.add(new TicketItem(
                "Jul 05, 2024", // DateTime
                "2:15 PM",       // Departure time
                "$55",           // Price
                "FL789",         // Flight number
                "Ho Chi Minh",   // From city
                "Da Nang",       // To city
                "SGN",           // From airport code
                "DNA",           // To airport code
                "Jul 05",        // Date
                "Ho Chi Minh (SGN)", // From airport
                "Da Nang (DNA)"      // To airport
        ));

        ticketList.add(new TicketItem(
                "Jul 05, 2024", // DateTime
                "10:30 AM",      // Departure time
                "$45",           // Price
                "VJ456",         // Flight number
                "Da Nang",       // From city
                "Ho Chi Minh",   // To city
                "DNA",           // From airport code
                "SGN",           // To airport code
                "Jul 05",        // Date
                "Da Nang (DNA)", // From airport
                "Ho Chi Minh (SGN)" // To airport
        ));


        return ticketList;
    }
}
