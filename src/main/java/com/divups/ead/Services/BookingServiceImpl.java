package com.divups.ead.Services;

import com.divups.ead.Entity.BookingEntity;
import com.divups.ead.Entity.BusEntity;
import com.divups.ead.Model.Booking;
import com.divups.ead.Model.Bus;
import com.divups.ead.Repository.BookingRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Booking> getBooking(Integer id) {
        return null;
    }


    @Override
    public List<Booking> getBookingByUser(Integer id) {

        List<BookingEntity> bookingEntities=bookingRepository.findByUser(id);

        List<Booking> bookings = bookingEntities.stream().map(booking1-> new Booking(booking1.getIdbooking(),
                booking1.getSeat_no(),
                booking1.getBooking_date(),
                booking1.getBusid(),
                booking1.getCustomer_id())).collect(Collectors.toList());

        return bookings;
    }

    @Override
    public boolean BookingDeleted(Integer id) {
        try {
            BookingEntity bookingEntity = bookingRepository.findById(id).get();
            bookingRepository.delete(bookingEntity);
            return true;
        }catch (Exception BusNotFound ){
            return false;
        }
    }

}
