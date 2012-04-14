package org.resthub.booking.web;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.booking.model.Booking;
import org.resthub.booking.repository.BookingRepository;
import org.resthub.booking.repository.UserRepository;
import org.resthub.web.controller.GenericControllerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Guillaume Zurbach
 */
@Controller @RequestMapping("/api/booking")
public class BookingController extends GenericControllerImpl<Booking, Long, BookingRepository> {

    @Inject
    @Named("bookingRepository")
    @Override
    public void setRepository(BookingRepository bookingRepository) {
        this.repository = bookingRepository;
    }
    
    @Inject
    @Named("userRepository")
    private UserRepository userRepository;

    /**
     * @param userId
     * 
     * @return all bookings made by user identified by userId
     */
    @RequestMapping(method = RequestMethod.GET, value = "user/{id}") @ResponseBody
    public List<Booking> getBookingsByUser(@PathVariable("id") Long userId) {
        List<Booking> bookings = null;

        if (userId != null) {
            bookings = repository.findByUser(userRepository.findOne(userId));;
        }
        if (bookings == null) {
            bookings = new ArrayList<Booking>();
        }

        return bookings;
    }

    @Override
    public Long getIdFromEntity(Booking booking) {
        return booking.getId();
    }
}
