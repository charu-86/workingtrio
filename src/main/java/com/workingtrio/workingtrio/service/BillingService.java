package com.workingtrio.workingtrio.service;

import com.workingtrio.workingtrio.model.Biling;
import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.response.ResponseData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillingService {

    public ResponseData getBillsFromUser(User UserId);
    public ResponseData getListOfBills();
    public ResponseData createBill(Long userId);
}
