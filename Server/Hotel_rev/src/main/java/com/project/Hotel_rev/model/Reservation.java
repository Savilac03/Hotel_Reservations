package com.project.Hotel_rev.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reservationId;

    @JsonProperty("hotelId")
    private int hotelId;

    private String name;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int guests;

    public Reservation(String name, LocalDate fromDate, LocalDate toDate, int guests){
        this.name = name;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.guests = guests;
    }
    @Override
    public String toString() {
        return "\n--------------------------------------------" +
                "\n Reservation Details" +
                "\n--------------------------------------------" +
                "\n Id: " + reservationId +
                "\n Hotel Id: " + hotelId +
                "\n Full Name: " + name +
                "\n Checkin Date: " + fromDate +
                "\n Checkout Date: " + toDate +
                "\n Guests: " + guests;
    }
}


