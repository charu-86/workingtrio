package com.workingtrio.workingtrio.controller;

import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/facility")
public class FacilityController {

    private final FacilityService facilityService;
    @GetMapping("/allFacility")
    public ResponseEntity<ResponseData> getListOfBills(){
        ResponseData responseData = facilityService.getAllFacility();
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.OK);
    }

    @GetMapping("/paging/{pageNumber}/{pageSize}")
    public ResponseEntity<ResponseData> getFacilityPagination(@PathVariable Integer pageNumber,@PathVariable Integer pageSize){
        ResponseData responseData = facilityService.getFacilityPagination(pageNumber,pageSize);
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
}
