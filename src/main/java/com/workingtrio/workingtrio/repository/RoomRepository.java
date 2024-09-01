package com.workingtrio.workingtrio.repository;

import com.workingtrio.workingtrio.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
