package com.workingtrio.workingtrio.service;

import com.workingtrio.workingtrio.model.Booking;
import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.response.ResponseData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
//    public ResponseData getBooking
    ResponseData getBookingByUserId (User userId);
    ResponseData getBookingFromAllUser ();
    ResponseData createBooking(Booking boookingDetails);
    ResponseData updateBooking (Booking bookingId);
}
