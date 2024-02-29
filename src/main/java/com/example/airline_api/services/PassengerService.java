package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).get();
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger updatedPassenger) {
        Passenger passenger = passengerRepository.findById(id).get();
            passenger.setName(updatedPassenger.getName());
            passenger.setEmail(updatedPassenger.getEmail());
            return passengerRepository.save(passenger);
    }



    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
