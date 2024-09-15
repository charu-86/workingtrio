package com.workingtrio.workingtrio.service.impl;

import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.repository.UserRepository;
import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.UserService;
import lombok.AllArgsConstructor;
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
                    .statusCode(404)
                    .data(users)
                    .build();
        }
        return ResponseData.builder()
                .statusMessage("Users found")
                .statusCode(200)
                .data(userRepository.findAll())
                .build();
    }

    @Override
    public ResponseData getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
            return ResponseData.builder()
                    .statusMessage("User not found")
                    .statusCode(404)
                    .data(user)
                    .build();
        }
        return ResponseData.builder()
                .statusMessage("User found")
                .statusCode(200)
                .data(user)
                .build();
    }

    @Override
    public ResponseData createUser(User user) {
        User newUser = userRepository.save(user);
        if (newUser == null){
            return ResponseData.builder()
                    .statusMessage("User not created")
                    .statusCode(400)
                    .data(newUser)
                    .build();
        }
        return ResponseData.builder()
                .statusMessage("User created")
                .statusCode(201)
                .data(newUser)
                .build();
    }

    @Override
    public ResponseData updateUser(Long userId, User user) {
        Optional<User> existingUser = userRepository.findById(userId);
        if(existingUser.isEmpty()){
            return ResponseData.builder()
                    .statusMessage("User not found")
                    .statusCode(404)
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
                .statusMessage("User updated")
                .statusCode(200)
                .data(updatedUser)
                .build();
    }

    @Override
    public ResponseData deleteUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
            return ResponseData.builder()
                    .statusMessage("User not found")
                    .statusCode(404)
                    .data(user)
                    .build();
        }
        userRepository.deleteById(userId);
        return ResponseData.builder()
                .statusMessage("User deleted")
                .statusCode(200)
                .data(user)
                .build();
    }
}
