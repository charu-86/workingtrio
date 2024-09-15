package com.workingtrio.workingtrio.service;

import com.workingtrio.workingtrio.model.Payment;
import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.response.ResponseData;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    ResponseData getPaymentsFromUserId(User userId);
    ResponseData getPaymentFromAllUsers();
    ResponseData CreatePayment(Payment paymentId);
}
