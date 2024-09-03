package com.workingtrio.workingtrio.controller;

import com.workingtrio.workingtrio.model.Biling;
import com.workingtrio.workingtrio.model.User;
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
    public ResponseEntity<ResponseData> getBillsByUserId(@PathVariable User id){
        ResponseData responseData = billingService.getBillsFromUser(id);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.OK);
    }

    @GetMapping("/allBills")
    public ResponseEntity<ResponseData> getListOfBills(){
        ResponseData responseData = billingService.getListOfBills();
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.OK);
    }

    @PostMapping("/createBill")
    public ResponseEntity<ResponseData> createBill(@RequestBody Biling bilingDetail){
        ResponseData responseData = billingService.createBill(bilingDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }

    @PutMapping("/updateBill/{id}")
    public ResponseEntity<ResponseData> updateBill(@RequestBody Biling updateBill ,@PathVariable Long id){
        ResponseData responseData = billingService.updateBill(updateBill, id);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
}