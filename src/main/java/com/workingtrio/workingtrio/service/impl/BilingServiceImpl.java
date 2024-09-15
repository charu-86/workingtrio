package com.workingtrio.workingtrio.service.impl;


import com.workingtrio.workingtrio.model.Biling;
import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.repository.BilingRepository;
import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.BillingService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BilingServiceImpl implements BillingService {

    private final BilingRepository bilingRepository;

    @Override
    public ResponseData getBillsFromUser(User userId) {

        Optional<List<Biling>> bills = bilingRepository.findByUserId(userId);
        if (bills.isPresent() && !bills.get().isEmpty()) {
            return ResponseData.builder()
                    .data(bills)
                    .statusCode(HttpStatus.OK.value())
                    .statusMessage("Success")
                    .build();
        }
        return ResponseData.builder()
                .data(bills)
                .statusCode(HttpStatus.NOT_FOUND.value())
                .statusMessage("Not Found")
                .build();
    }

    @Override
    public ResponseData getListOfBills() {
        List<Biling> listOfBills = bilingRepository.findAll();
        if (!listOfBills.isEmpty()) {
            return ResponseData.builder()
                    .data(listOfBills)
                    .statusCode(HttpStatus.OK.value())
                    .statusMessage("Success")
                    .build();
        }
        return ResponseData.builder()
                .data(listOfBills)
                .statusCode(HttpStatus.NOT_FOUND.value())
                .statusMessage("Not Found")
                .build();
    }

    @Override
    public ResponseData createBill(Biling billingDetail) {
        if (Objects.isNull(billingDetail)) {
            return ResponseData.builder()
                    .statusMessage("Not a valid Data")
                    .data(null)
                    .statusCode(HttpStatus.UNAUTHORIZED.value())
                    .build();
        }
        Biling biling = bilingRepository.save(
                Biling.builder()
                        .facilityType(billingDetail.getFacilityType())
                        .price(billingDetail.getPrice())
                        .userId(billingDetail.getUserId())
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return ResponseData.builder()
                .statusCode(HttpStatus.CREATED.value())
                .statusMessage("Created")
                .data(biling)
                .build();
    }

    @Override
    public ResponseData updateBill(Biling updatedBill, Long id){
        Optional<Biling> bill = bilingRepository.findById(id);
        if(bill.isPresent()){
            bill.get().setPrice(updatedBill.getPrice());
            bill.get().setFacilityType(updatedBill.getFacilityType());
            bilingRepository.save(bill.get());
            return ResponseData.builder()
                    .data("Value updated.")
                    .statusCode(HttpStatus.NO_CONTENT.value())
                    .statusMessage("Updated")
                    .build();
        }
        return ResponseData.builder()
                .data("Value not updated.")
                .statusMessage("Bad Request")
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();
    }

}
