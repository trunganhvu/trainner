package com.example.springjparest.onetomany.simplepk.service;

import com.example.springjparest.onetomany.simplepk.exception.RestaurantNotFoundException;
import com.example.springjparest.onetomany.simplepk.model.Restaurant;
import com.example.springjparest.onetomany.simplepk.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant validateAndGetRestaurant(String id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Restaurant restaurant) {
        restaurantRepository.delete(restaurant);
    }
}
