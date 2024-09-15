package com.workingtrio.workingtrio.service.impl;

import com.workingtrio.workingtrio.model.Facility;
import com.workingtrio.workingtrio.repository.FacilityRepository;
import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;
    @Override
    public ResponseData getAllFacility() {
        List<Facility> listOfFacility = facilityRepository.findAll();

        if(!listOfFacility.isEmpty()){

            return ResponseData.builder()
                    .data(listOfFacility)
                    .statusCode(HttpStatus.OK.value())
                    .statusMessage("Success")
                    .build();
        }

        return ResponseData.builder()
                .data(listOfFacility)
                .statusCode(HttpStatus.NOT_FOUND.value())
                .statusMessage("Not Found")
                .build();
    }
    @Override
    public ResponseData getFacilityPagination(Integer pagenumber, Integer pagesize) {

        Pageable pageable = PageRequest.of(pagenumber, pagesize);
        Page<Facility> facilities = facilityRepository.findAll(pageable);

        if (!facilities.isEmpty()){
            return ResponseData.builder()
                    .data(facilities)
                    .statusCode(HttpStatus.OK.value())
                    .statusMessage("Success")
                    .build();
        }

        return ResponseData.builder()
                .data(facilities)
                .statusCode(HttpStatus.NOT_FOUND.value())
                .statusMessage("Not Found")
                .build();
    }
}

