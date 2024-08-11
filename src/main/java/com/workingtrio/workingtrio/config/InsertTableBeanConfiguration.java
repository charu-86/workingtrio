package com.workingtrio.workingtrio.config;

import com.workingtrio.workingtrio.model.UserType;
import com.workingtrio.workingtrio.repository.UserTypeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InsertTableBeanConfiguration {

    private final UserTypeRepository userTypeRepository;

    @Bean
    public String saveUserType(){
        userTypeRepository.save(new UserType(1l,"ADMIN"));
        userTypeRepository.save(new UserType(2l,"STAFF"));
        userTypeRepository.save(new UserType(3l,"GUEST"));
        return "SUCCESS";
    }
}
