package com.workingtrio.workingtrio.service.impl;

import com.workingtrio.workingtrio.model.Room;
import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.repository.RoomRepository;
import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    RoomRepository roomRepository;

    @Override
    public ResponseData getAllRooms(){
        List<Room> rooms= roomRepository.findAll();
        if(rooms.isEmpty()){
            return ResponseData.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .statusMessage("No rooms found")
                    .data(rooms)
                    .build();
        }
        return ResponseData.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Rooms found")
                .data(rooms)
                .build();
    }

    @Override
    public ResponseData getRoomById(Long id){
        Optional<Room> room = roomRepository.findById(id);
        if(room.isEmpty()){
            return ResponseData.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .statusMessage("Room not found")
                    .data(room)
                    .build();
        }
        return ResponseData.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Room found")
                .data(room)
                .build();
    }

    @Override
    public ResponseData addRoom(Room room){
        Room newRoom = roomRepository.save(room);
        return ResponseData.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Room created")
                .data(newRoom)
                .build();
    }

    @Override
    public ResponseData updateRoom(Long id, Room room){
        Optional<Room> existingRoom = roomRepository.findById(id);
        if(existingRoom.isEmpty()){
            return ResponseData.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .statusMessage("Room not found")
                    .data(existingRoom)
                    .build();
        }
        Room updatedRoom = existingRoom.get();
        updatedRoom.setAvailable(room.isAvailable());
        updatedRoom.setNumber(room.getNumber());
        updatedRoom.setUserID(room.getUserID());
        roomRepository.save(updatedRoom);
        return ResponseData.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Room updated")
                .data(updatedRoom)
                .build();
    }

    @Override
    public ResponseData vacantRoom(Room room){
        if(room.isAvailable()){
            return ResponseData.builder()
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .statusMessage("Room already vacant")
                    .data(room)
                    .build();
        }
        room.setUserID(null);
        room.setAvailable(true);
        roomRepository.save(room);
        return ResponseData.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Room status changed")
                .data(room)
                .build();
    }

    @Override
    public ResponseData bookRoom(Room room, User user){
        if(!room.isAvailable()){
            return ResponseData.builder()
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .statusMessage("Room already occupied")
                    .data(room)
                    .build();
        }
        room.setUserID(user);
        room.setAvailable(false);
        roomRepository.save(room);
        return ResponseData.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Room booked")
                .data(room)
                .build();
    }

    @Override
    public ResponseData deleteRoom(Long id){
        Optional<Room> room = roomRepository.findById(id);
        if(room.isEmpty()){
            return ResponseData.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .statusMessage("Room not found")
                    .data(room)
                    .build();
        }
        roomRepository.delete(room.get());
        return ResponseData.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Room deleted")
                .data(room)
                .build();
    }

    @Override
    public ResponseData getRoomsByUserId(User user){
        Optional<List<Room>> rooms = roomRepository.findByUserID(user);
        if(rooms.isEmpty()){
            return ResponseData.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .statusMessage("No rooms found")
                    .data(rooms)
                    .build();
        }
        return ResponseData.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Rooms found")
                .data(rooms)
                .build();
    }

    @Override
    public ResponseData getRoomsByAvailability(boolean isAvailable){
        Optional<List<Room>> rooms = roomRepository.findByIsAvailable(isAvailable);
        if(rooms.isEmpty()){
            return ResponseData.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .statusMessage("No rooms found")
                    .data(rooms)
                    .build();
        }
        return ResponseData.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Rooms found")
                .data(rooms)
                .build();
    }

    @Override
    public ResponseData getRoomByNumber(Integer number){
        Optional<Room> room = roomRepository.findByNumber(number);
        if(room.isEmpty()){
            return ResponseData.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .statusMessage("Room not found")
                    .data(room)
                    .build();
        }
        return ResponseData.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Room found")
                .data(room)
                .build();
    }

}
