package com.workingtrio.workingtrio.service;

import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.response.ResponseData;
import org.springframework.stereotype.Service;

@Service
public interface FacilityService {
    ResponseData getAllFacility();
    ResponseData getFacilityPagination(Integer pagenumber, Integer pagesize);
}
