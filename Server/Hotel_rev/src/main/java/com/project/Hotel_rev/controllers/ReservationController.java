package com.project.Hotel_rev.controllers;

import com.project.Hotel_rev.dao.ReservationDao;
import com.project.Hotel_rev.exception.HotelNotFoundException;
import com.project.Hotel_rev.exception.ReservationNotFoundException;
import com.project.Hotel_rev.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class ReservationController {
    private ReservationDao reservationDao;

        @GetMapping("/reservations")
        public List<Reservation> listReservations(){
            return reservationDao.findAll();
        }

        @GetMapping ("/reservations/{id}")
        public Optional<Reservation> getReservation(@PathVariable int id) throws ReservationNotFoundException {
            return reservationDao.findById(id);
        }

        @GetMapping("/{id}/reservations")
        public Optional<Reservation> listReservationsByHotel(@PathVariable("id") int hotelId) throws HotelNotFoundException {
            return reservationDao.findById(hotelId);
        }

        @PostMapping("/reservations")
        public Reservation addReservation(@RequestBody Reservation reservation) throws HotelNotFoundException{
            return reservationDao.save(reservation);
        }

        @PutMapping("/reservations/{id}")
        public Reservation updateReservation (@RequestBody Reservation reservation, @PathVariable int id) throws ReservationNotFoundException{

            Reservation updatedReservation = reservationDao.getReferenceById(id);

            updatedReservation.setName(reservation.getName());
            updatedReservation.setFromDate(reservation.getFromDate());
            updatedReservation.setToDate(reservation.getToDate());
            updatedReservation.setGuests(reservation.getGuests());

            return reservationDao.save(updatedReservation);
        }
        @ResponseStatus(HttpStatus.NO_CONTENT)
        @DeleteMapping("/reservations/{id}")
        public void delete(@PathVariable int id) throws ReservationNotFoundException{
            Reservation reservation = reservationDao.getReferenceById(id);
            reservationDao.delete(reservation);
        }

    }
