package com.workingtrio.workingtrio.controller;

import com.workingtrio.workingtrio.model.Payment;
import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/getPaymentFromUserId/{UserId}")
    public ResponseEntity<ResponseData> getPaymentsFromUserId(@PathVariable User userId ){
        ResponseData responseData = paymentService.getPaymentsFromUserId(userId);
        return new ResponseEntity<>(responseData, HttpStatusCode.valueOf(responseData.getStatusCode()));
    }

    @GetMapping("/getPaymentFromAllUsers")
    public ResponseEntity<ResponseData> getPaymentFromAllUsers(){
        ResponseData responseData = paymentService.getPaymentFromAllUsers();
        return new ResponseEntity<>(responseData, HttpStatusCode.valueOf(responseData.getStatusCode()));
    }

    @PostMapping("/CreatePayment")
    public ResponseEntity<ResponseData> CreatePayment(@RequestBody Payment paymentId){
        ResponseData responseData = paymentService.CreatePayment(paymentId);
        return new ResponseEntity<>(responseData, HttpStatusCode.valueOf(responseData.getStatusCode()));
    }
}
