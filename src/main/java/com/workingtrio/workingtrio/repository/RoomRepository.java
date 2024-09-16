package com.workingtrio.workingtrio.repository;

import com.workingtrio.workingtrio.model.Room;
import com.workingtrio.workingtrio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<List<Room>> findByUserID(User user);
    Optional<List<Room>> findByIsAvailable(boolean isAvailable);
    Optional<Room> findByNumber(Integer number);
}
