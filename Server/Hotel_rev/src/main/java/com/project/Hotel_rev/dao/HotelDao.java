package com.project.Hotel_rev.dao;

import com.project.Hotel_rev.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelDao extends JpaRepository<Hotel,Integer> {

    Hotel findById(int id);
    List<Hotel> findByName(String name);
    List<Hotel> findByAddress(String Address);

    List<Hotel> findByNumOfRooms(int numOfRooms);

}
