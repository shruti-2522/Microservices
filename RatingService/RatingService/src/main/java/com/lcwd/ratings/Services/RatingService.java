package com.lcwd.ratings.Services;

import com.lcwd.ratings.Entities.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getAllRatingsByuserId(String userId);

    List<Rating> getAllRatingsByhotelId(String hotelId);
}
