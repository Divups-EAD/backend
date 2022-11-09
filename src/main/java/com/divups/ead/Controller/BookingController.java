package com.divups.ead.Controller;

import com.divups.ead.Entity.BookingEntity;
import com.divups.ead.Entity.UserEntity;
import com.divups.ead.Model.Booking;
import com.divups.ead.Repository.BookingRepository;
import com.divups.ead.Services.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")



public class BookingController {

    private final BookingRepository bookingRepository;

    final BookingService bookingService;

    public BookingController(BookingService bookingService, BookingRepository bookingRepository) {
        this.bookingService = bookingService;
        this.bookingRepository = bookingRepository;
    }

    @PostMapping("/booking")
    public Booking AddBooking(@RequestBody Booking booking){
        return bookingService.AddBooking(booking);
    }

    @GetMapping("/booking/{id}")
    public List<Booking> getBookingByUser(@PathVariable Integer id){
        return bookingService.getBookingByUser(id);
    }

    @DeleteMapping("booking/{id}")
    public ResponseEntity<Map<String , Boolean>> deleteBooking(@PathVariable Integer id) {
        boolean deleted = false;

        deleted = bookingService.BookingDeleted(id);

        Map<String , Boolean> response = new HashMap<>();
        response.put("deleted" , deleted);
        return ResponseEntity.ok(response);
    }

}
