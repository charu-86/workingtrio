package com.workingtrio.workingtrio.controller;

import com.workingtrio.workingtrio.model.Booking;
import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.repository.BookingRepository;
import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/api/booking")
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/getBookingByUserId/{id}")
    public ResponseEntity<ResponseData> getBookingByUserId(@PathVariable User userId){
        ResponseData responseData = bookingService.getBookingByUserId(userId);
        return new ResponseEntity<>(responseData, HttpStatusCode.valueOf(responseData.getStatusCode()));
    }

    @GetMapping("/getBookingFromAllUser")
    public ResponseEntity<ResponseData> getBookingFromAllUser(){
        ResponseData responseData = bookingService.getBookingFromAllUser();
        return new ResponseEntity<>(responseData, HttpStatusCode.valueOf(responseData.getStatusCode()));
    }

    @PostMapping("/createBooking")
    public ResponseEntity<ResponseData> createBooking(@RequestBody Booking bookingDetails){
        ResponseData responseData = bookingService.createBooking(bookingDetails);
        return new ResponseEntity<>(responseData, HttpStatusCode.valueOf(responseData.getStatusCode()));
    }

    @PutMapping("/updateBooking")
    public ResponseEntity<ResponseData> updateBooking(@RequestBody Booking bookingId){
        ResponseData responseData = bookingService.updateBooking(bookingId);
        return new ResponseEntity<>(responseData, HttpStatusCode.valueOf(responseData.getStatusCode()));
    }
}
