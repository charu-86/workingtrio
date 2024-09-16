package com.workingtrio.workingtrio.service;

import com.workingtrio.workingtrio.model.Room;
import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.response.ResponseData;
import org.springframework.stereotype.Service;

@Service
public interface RoomService {
    ResponseData getAllRooms();
    ResponseData getRoomById(Long id);
    ResponseData addRoom(Room room);
    ResponseData updateRoom(Long id, Room room);
    ResponseData vacantRoom(Room room);
    ResponseData bookRoom(Room room, User user);
    ResponseData deleteRoom(Long id);
    ResponseData getRoomsByUserId(User user);
    ResponseData getRoomsByAvailability(boolean isAvailable);
    ResponseData getRoomByNumber(Integer number);
}
