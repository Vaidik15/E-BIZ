package com.hammy.homster_hotel.service;

import com.hammy.homster_hotel.model.BookedRoom;

import java.util.List;

public interface BookedRoomService {
    List<BookedRoom> getAllBookingsByRoomId(Long roomId);
}
