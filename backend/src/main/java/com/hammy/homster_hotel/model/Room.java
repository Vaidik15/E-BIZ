package com.hammy.homster_hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomType;

    private BigDecimal roomPrice;

    private boolean isBooked = false;

    @Lob
    private Blob photo; // for room photo

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // when deleted, all bookings also deleted
    private List<BookedRoom> bookings;

    public Room() {
        this.bookings = new ArrayList<>();
    }

    public void addBookings(BookedRoom addBookings) {
        if (bookings == null) {
            bookings = new ArrayList<>();
        }
        bookings.add(addBookings);
        addBookings.setRoom(this);
        isBooked = true;
        String bookingCode = RandomStringUtils.randomNumeric(10); // 10 digits long code
        addBookings.setBookingConfirmationCode(bookingCode);
    }
}
