package com.project.Hotel_rev.controllers;

import com.project.Hotel_rev.dao.HotelDao;
import com.project.Hotel_rev.dao.ReservationDao;
import com.project.Hotel_rev.exception.HotelNotFoundException;
import com.project.Hotel_rev.exception.ReservationNotFoundException;
import com.project.Hotel_rev.model.Hotel;
import com.project.Hotel_rev.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelDao hotelDao;


    public HotelController (HotelDao hotelDao){
        this.hotelDao = hotelDao;

    }

    @GetMapping
    public List<Hotel> getAllHotels(){
        return hotelDao.findAll();
    }

    @GetMapping("/{id}")
    public Hotel getByHotelId(@PathVariable int id){
        return hotelDao.findById(id);
    }

    @GetMapping("/findByName")
    public List<Hotel> getHotelByName(@RequestParam String name){
        return hotelDao.findByName(name);
    }

    @GetMapping("/findByAddress")
    public List<Hotel> getHotelByAddress(@RequestParam String address){
        return hotelDao.findByAddress(address);
    }

    @GetMapping("/findByNumOfRooms")
    public List<Hotel> getHotelByRooms(@RequestParam int numOfRooms){
        return hotelDao.findByNumOfRooms(numOfRooms);
    }

    @PostMapping()
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelDao.save(hotel);
    }

    @PutMapping()
    public Hotel updateHotel (@RequestBody Hotel hotel, @PathVariable int id) throws HotelNotFoundException {

        Hotel updatedHotel = hotelDao.getReferenceById(id);

        updatedHotel.setName(hotel.getName());
        updatedHotel.setInformation(hotel.getInformation());
        updatedHotel.setImage(hotel.getImage());
        updatedHotel.setAddress(hotel.getAddress());
        updatedHotel.setNumOfRooms(hotel.getNumOfRooms());

        return hotelDao.save(updatedHotel);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws HotelNotFoundException{
        Hotel hotel = hotelDao.findById(id);
        hotelDao.delete(hotel);
    }




}
