package com.divups.ead.Controller;

import com.divups.ead.Model.Booking;
import com.divups.ead.Services.BookingService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class BookingController {
    final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public Booking AddBooking(@RequestBody Booking booking){
        return bookingService.AddBooking(booking);
    }

}
