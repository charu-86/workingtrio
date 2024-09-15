package com.workingtrio.workingtrio.service.impl;

import com.workingtrio.workingtrio.model.Payment;
import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.repository.PaymentRepository;
import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.BillingService;
import com.workingtrio.workingtrio.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    @Override
    public ResponseData getPaymentsFromUserId(User userId){
        Optional<List<Payment>> payments = paymentRepository.findByUserId(userId);
        if(payments.isPresent() && !payments.get().isEmpty()){
            return ResponseData.builder()
                    .data(payments)
                    .statusCode(HttpStatus.OK.value())
                    .statusMessage("Success")
                    .build();
        }
        return ResponseData.builder()
                .data(payments)
                .statusCode(HttpStatus.NOT_FOUND.value())
                .statusMessage("Not Found")
                .build();
    }

    @Override
    public ResponseData getPaymentFromAllUsers() {
        List<Payment> listOfPayment = paymentRepository.findAll();
        if(listOfPayment.isEmpty()){
            return ResponseData.builder()
                    .data(listOfPayment)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .statusMessage("Not Found")
                    .build();
        }
        return ResponseData.builder()
                .data(listOfPayment)
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Success")
                .build();
    }

    @Override
    public ResponseData CreatePayment(Payment payment) {
        if(Objects.isNull(payment)){
            ResponseData.builder()
                    .data(payment)
                    .statusMessage("UNAUTHORIZED")
                    .statusCode(HttpStatus.UNAUTHORIZED.value())
                    .build();
        }
        Payment payment1 = paymentRepository.save(
                Payment.builder()
                        .paymentMode(payment.getPaymentMode())
                        .userId(payment.getUserId())
                        .billingID(payment.getBillingID())
                        .status(payment.getStatus())
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return ResponseData.builder()
                .data(payment)
                .statusCode(HttpStatus.CREATED.value())
                .statusMessage("Created")
                .build();
    }


}
