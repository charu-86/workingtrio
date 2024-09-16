package com.workingtrio.workingtrio.service.impl;

import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.repository.UserRepository;
import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public ResponseData getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()){
            return ResponseData.builder()
                    .statusMessage("Users not found")
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(users)
                    .build();
        }
        return ResponseData.builder()
                .statusMessage("Users found")
                .statusCode(HttpStatus.OK.value())
                .data(userRepository.findAll())
                .build();
    }

    @Override
    public ResponseData getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
            return ResponseData.builder()
                    .statusMessage("User not found")
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(user)
                    .build();
        }
        return ResponseData.builder()
                .statusMessage("User found")
                .statusCode(HttpStatus.OK.value())
                .data(user)
                .build();
    }

    @Override
    public ResponseData createUser(User user) {
        User newUser = userRepository.save(user);
        if (newUser == null){
            return ResponseData.builder()
                    .statusMessage("User not created")
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .data(newUser)
                    .build();
        }
        return ResponseData.builder()
                .statusMessage("User created")
                .statusCode(HttpStatus.CREATED.value())
                .data(newUser)
                .build();
    }

    @Override
    public ResponseData updateUser(Long userId, User user) {
        Optional<User> existingUser = userRepository.findById(userId);
        if(existingUser.isEmpty()){
            return ResponseData.builder()
                    .statusMessage("User not found")
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(existingUser)
                    .build();
        }
        User updatedUser = existingUser.stream().findFirst().get();
        updatedUser.setUserName(user.getUserName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setMobNo(user.getMobNo());
        updatedUser.setAdmin(user.isAdmin());
        updatedUser.setStaff(user.isStaff());
        updatedUser.setGuest(user.isGuest());
        userRepository.save(updatedUser);
        return ResponseData.builder()
                .statusMessage("User details updated")
                .statusCode(HttpStatus.OK.value())
                .data(updatedUser)
                .build();
    }

    @Override
    public ResponseData deleteUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
            return ResponseData.builder()
                    .statusMessage("User not found")
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(user)
                    .build();
        }
        userRepository.deleteById(userId);
        return ResponseData.builder()
                .statusMessage("User deleted")
                .statusCode(HttpStatus.OK.value())
                .data(user)
                .build();
    }
}
