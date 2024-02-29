package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Flight flight1 = new Flight("New York", 200, "2024-03-15", "08:00");
        Flight flight2 = new Flight("London", 150, "2024-03-20", "10:30");
        Flight flight3 = new Flight("Tokyo", 180, "2024-03-25", "14:15");
        flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3));


        Passenger passenger1 = new Passenger("John Doe", "john@example.com");
        Passenger passenger2 = new Passenger("Jane Smith", "jane@example.com");
        Passenger passenger3 = new Passenger("Alice Johnson","alice@example.com");
        passengerRepository.saveAll(Arrays.asList(passenger1, passenger2, passenger3));

        flight1.addPassenger(passenger1);
        flight2.addPassenger(passenger1);
        flight2.addPassenger(passenger2);
        flight3.addPassenger(passenger3);
        flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3));

    }
}

