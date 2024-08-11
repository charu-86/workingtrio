package com.workingtrio.workingtrio.config;

import com.workingtrio.workingtrio.model.Facility;
import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.repository.FacilityRepository;
import com.workingtrio.workingtrio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InsertTableBeanConfiguration {

    private final FacilityRepository facilityRepository;
    private final UserRepository userRepository;

    @Bean
    public String saveUser() {
        userRepository.save(new User(1l, "Charu", "charu@gmail.com", "649748364", true, false, false));
        userRepository.save(new User(2l, "Ankit", "ankit@gmail.com", "729748364", false, true, true));
        userRepository.save(new User(3l, "Aditya", "aditya@gmail.com", "987655687", true, true, false));
        return "SUCCESS";
    }

    @Bean
    public String facilities(){
        facilityRepository.save(new Facility(1l,"Stay", true));
        facilityRepository.save(new Facility(2l,"DineIn", true));
        return "Success";
    }

}
