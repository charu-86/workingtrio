package com.workingtrio.workingtrio.service.impl;

import com.workingtrio.workingtrio.model.Booking;
import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.repository.BookingRepository;
import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    public final BookingRepository bookingRepository;
    @Override
    public ResponseData getBookingByUserId(User userId) {
        Optional<List<Booking>> bookings = bookingRepository.findByUserId(userId);
        if(Objects.isNull(userId)){
            return ResponseData.builder()
                    .statusMessage("Not Found")
                    .data(null)
                    .statusCode(HttpStatus.UNAUTHORIZED.value())
                    .build();
        }
        return ResponseData.builder()
                .data(userId)
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Success")
                .build();
    }

    @Override
    public ResponseData getBookingFromAllUser() {
        List<Booking> bookingList = bookingRepository.findAll();
        if(bookingList.isEmpty()){
            return ResponseData.builder()
                    .statusMessage("Not Found")
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(bookingList)
                    .build();
        }
        return ResponseData.builder()
                .data(bookingList)
                .statusCode(HttpStatus.OK.value())
                .statusMessage("OK")
                .build();
    }

    @Override
    public ResponseData createBooking(Booking boookingDetails) {
        if(Objects.isNull(boookingDetails)){
            return ResponseData.builder()
                    .data(null)
                    .statusMessage("UNAUTHORISED")
                    .statusCode(HttpStatus.UNAUTHORIZED.value())
                    .build();
        }
        Booking booking = bookingRepository.save(
                Booking.builder()
                .userId(boookingDetails.getUserId())
                .bookingDateTime(LocalDateTime.now())
                .facilityType(boookingDetails.getFacilityType())
                .checkoutDateTime(boookingDetails.getCheckoutDateTime())
                .build()
    );
        return ResponseData.builder()
                .data(booking)
                .statusCode(HttpStatus.CREATED.value())
                .statusMessage("Created")
                .build();

    }

    @Override
    public ResponseData updateBooking(Booking bookingId) {
        Optional<Booking> updateBooking = bookingRepository.findById(bookingId.getId());
        if(updateBooking.isEmpty()){
            return ResponseData.builder()
                    .data(null)
                    .statusMessage("UNAUTHORISED")
                    .statusCode(HttpStatus.UNAUTHORIZED.value())
                    .build();
        }
        Booking updatedBooking = updateBooking.stream().findFirst().get();
                        updatedBooking.setUserId(bookingId.getUserId());
                        updatedBooking.setFacilityType(bookingId.getFacilityType());
                        updatedBooking.setCheckoutDateTime(bookingId.getCheckoutDateTime());
                        bookingRepository.save(updatedBooking);
        return ResponseData.builder()
                .data(updatedBooking)
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Updated")
                .build();

    }
}
