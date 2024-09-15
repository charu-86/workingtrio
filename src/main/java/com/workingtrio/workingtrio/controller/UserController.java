package com.workingtrio.workingtrio.controller;

import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<ResponseData> getAllUsers(){
        ResponseData responseData = userService.getAllUsers();
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<ResponseData> getUserById(@PathVariable Long userId){
        ResponseData responseData = userService.getUserById(userId);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @PostMapping
    public ResponseEntity<ResponseData> createUser(@RequestBody User user) {
        ResponseData responseData = userService.createUser(user);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @PutMapping("/userId/{userId}")
    public ResponseEntity<ResponseData> updateUser(@PathVariable Long userId, @RequestBody User user) {
        ResponseData responseData = userService.updateUser(userId, user);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @DeleteMapping("/userId/{userId}")
    public ResponseEntity<ResponseData> deleteUser(@PathVariable Long userId) {
        ResponseData responseData = userService.deleteUser(userId);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }
}
