package com.lcwd.user.service.Impl;

import com.lcwd.user.service.Entities.Hotel;
import com.lcwd.user.service.Entities.Rating;
import com.lcwd.user.service.Entities.User;
import com.lcwd.user.service.Repositories.UserRepository;
import com.lcwd.user.service.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    //private Logger log=LogFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomuserId= UUID.randomUUID().toString();
        user.setUserId(randomuserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return  userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("Given user id is not found on server:"+userId));
        //Calling Rating service:
        //http://localhost:8086/Ratings/users/39d6c636-4002-4847-b075-4ae7eee32475
        Rating[] ratingOfUser=restTemplate.getForObject("http://RATINGSERVICE/Ratings/users/"+user.getUserId(), Rating[].class);
       List<Rating> ratings=Arrays.stream(ratingOfUser).toList();
        //log.info("Data:"+forObj);

       List<Rating> ratinglist= ratings.stream().map(rating->{
            ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel=forEntity.getBody();
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratinglist);

        return user;
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
