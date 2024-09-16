package com.workingtrio.workingtrio.controller;

import com.workingtrio.workingtrio.model.Room;
import com.workingtrio.workingtrio.model.User;
import com.workingtrio.workingtrio.response.ResponseData;
import com.workingtrio.workingtrio.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@AllArgsConstructor
@RequestMapping("/api/room")
public class RoomController {
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<ResponseData> getAllRooms(){
        ResponseData responseData = roomService.getAllRooms();
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData> getRoomById(@PathVariable Long id){
        ResponseData responseData = roomService.getRoomById(id);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @PostMapping
    public ResponseEntity<ResponseData> addRoom(@RequestBody Room room){
        ResponseData responseData = roomService.addRoom(room);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseData> updateRoom(@PathVariable Long id, @RequestBody Room room){
        ResponseData responseData = roomService.updateRoom(id, room);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @PutMapping("/vacant/{id}")
    public ResponseEntity<ResponseData> vacantRoom(@PathVariable Room room){
        ResponseData responseData = roomService.vacantRoom(room);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @PutMapping("/{room}/user/{user}")
    public ResponseEntity<ResponseData> bookRoom(@PathVariable Room room, @PathVariable User user){
        ResponseData responseData = roomService.bookRoom(room, user);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData> deleteRoom(@PathVariable Long id){
        ResponseData responseData = roomService.deleteRoom(id);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<ResponseData> getRoomsByUserId(@PathVariable User user){
        ResponseData responseData = roomService.getRoomsByUserId(user);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @GetMapping("/status")
    public ResponseEntity<ResponseData> getRoomsByAvailability(@RequestParam Boolean isAvailable){
        ResponseData responseData = roomService.getRoomsByAvailability(isAvailable);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

    @GetMapping("/status/{roomNumber}")
    public ResponseEntity<ResponseData> getRoomByNumber(@PathVariable Integer roomNumber){
        ResponseData responseData = roomService.getRoomByNumber(roomNumber);
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.valueOf(responseData.getStatusCode()));
    }

}
