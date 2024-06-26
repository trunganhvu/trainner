package com.example.springjparest.onetomany.simplepk.service;

import com.example.springjparest.onetomany.simplepk.model.Restaurant;

public interface RestaurantService {

    Restaurant validateAndGetRestaurant(String id);

    Restaurant saveRestaurant(Restaurant restaurant);

    void deleteRestaurant(Restaurant restaurant);
}