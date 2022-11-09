package com.divups.ead.Services;

import com.divups.ead.Model.Booking;

import java.util.List;

public interface BookingService {
    Booking AddBooking(Booking booking);

    List<Booking> getBooking(Integer id);

    List<Booking> getBookingByUser(Integer id);

    boolean BookingDeleted(Integer id);
}
