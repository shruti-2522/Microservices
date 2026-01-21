package com.lcwd.ratings.Controllers;

import com.lcwd.ratings.Entities.Rating;
import com.lcwd.ratings.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ratings")
public class RateController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>>getRatings(){
        return  ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>>getRatingByUserId(@PathVariable String userId){
        return  ResponseEntity.ok(ratingService.getAllRatingsByuserId(userId));
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>>getRatingByHotelId(@PathVariable String hotelId){
        return  ResponseEntity.ok(ratingService.getAllRatingsByhotelId(hotelId));
    }
}
