package com.lcwd.hotel.hotelService.Services;

import com.lcwd.hotel.hotelService.Entities.Hotel;
import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel getHotelById(String id);
}