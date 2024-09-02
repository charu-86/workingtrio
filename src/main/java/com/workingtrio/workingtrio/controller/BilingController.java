package com.workingtrio.workingtrio.controller;

import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/biling")
public class BilingController {
    private final BillingService billingService;

    @GetMapping("/userId/{id}")
    public ResponseEntity<ResponseData> getBillsByUserId(@PathVariable Long id){
        ResponseData responseData = billingService.getBillsFromUser(id);

        return new ResponseEntity<ResponseData>(responseData, HttpStatus.OK);
    }
}
