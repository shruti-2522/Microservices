package com.lcwd.ratings.Repositories;

import com.lcwd.ratings.Entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;

public interface RatingRepository extends MongoRepository<Rating,String> {
    //Custom finder methods
    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
