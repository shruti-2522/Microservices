package com.lcwd.hotel.hotelService.Impl;

import com.lcwd.hotel.hotelService.Entities.Hotel;
import com.lcwd.hotel.hotelService.Exceptions.ResourceNotFoundException;
import com.lcwd.hotel.hotelService.Reopositories.HotelRepository;
import com.lcwd.hotel.hotelService.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements  HotelService{

    @Autowired
    private HotelRepository hotelRepo;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId=UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {

        return hotelRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with given id not found!!"));
    }
}