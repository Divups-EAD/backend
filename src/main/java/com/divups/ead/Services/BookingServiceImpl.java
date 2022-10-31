package com.divups.ead.Services;

import com.divups.ead.Entity.BookingEntity;
import com.divups.ead.Model.Booking;
import com.divups.ead.Repository.BookingRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{

    final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking AddBooking(Booking booking) {

        BookingEntity bookingEntity = new BookingEntity();
        BeanUtils.copyProperties(booking,bookingEntity);
        bookingRepository.save(bookingEntity);

        return booking;
    }

}
