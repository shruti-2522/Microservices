package com.lcwd.ratings.Impl;

import com.lcwd.ratings.Entities.Rating;
import com.lcwd.ratings.Repositories.RatingRepository;
import com.lcwd.ratings.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingImpl implements RatingService {
@Autowired
private RatingRepository ratingRepository;

@Override
public Rating create(Rating rating) {
    return  ratingRepository.save(rating);
}

@Override
public List<Rating> getAllRatings() {
    return ratingRepository.findAll();
}

@Override
public List<Rating> getAllRatingsByuserId(String userId) {
    return ratingRepository.findByUserId(userId);
}

@Override
public List<Rating> getAllRatingsByhotelId(String hotelId) {
    return ratingRepository.findByHotelId(hotelId);
}}
