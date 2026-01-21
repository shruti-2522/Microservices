package com.lcwd.hotel.hotelService.Reopositories;

import com.lcwd.hotel.hotelService.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}