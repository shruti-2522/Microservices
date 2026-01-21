package com.lcwd.hotel.hotelService.Controllers;


import com.lcwd.hotel.hotelService.Entities.Hotel;
import com.lcwd.hotel.hotelService.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotels(@RequestBody Hotel hotel){
        return  ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));

    }

    @GetMapping("/{Id}")
    public  ResponseEntity<Hotel> getSingleHotels(@PathVariable  String Id){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(Id));
    }

    @GetMapping
    public  ResponseEntity<List<Hotel>> getALlHotels(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
    }
}