package com.workingtrio.workingtrio.service;

import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.response.ResponseData;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    ResponseData getUserById(Long userId);
    ResponseData createUser(User user);
    ResponseData updateUser(Long userId, User user);
    ResponseData getAllUsers();
    ResponseData deleteUser(Long userId);
}
