package com.dao;

import java.time.LocalTime;
import java.util.List;

import com.Model.Restaurant;

public interface RestaurantDao
{
	boolean addRestaurant(Restaurant r);
	boolean updateRestaurantMobileNo(int id,long mb);
	boolean updateRestaurantName(int id,String newname);
	boolean deleteRestaurant(int id);
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurant(int id);
	//List<Restaurant> getRestaurant(int id);
	boolean activateRestaurant(int id);
	boolean deactivateRestaurant(int id);
	

}
