package com.project.Hotel_rev.dao;

import com.project.Hotel_rev.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationDao extends JpaRepository<Reservation,Integer> {

}
