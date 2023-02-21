package com.project.Hotel_rev.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.UnresolvedType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hotelId;
    private int numOfRooms;
    private String name;
    private String information;
    private String image;
    private String address;

    public Hotel(String name, String information, String image, String address, int numOfRooms){
        this.name = name;
        this.information = information;
        this.image = image;
        this.address = address;
        this.numOfRooms = numOfRooms;
    }

}
