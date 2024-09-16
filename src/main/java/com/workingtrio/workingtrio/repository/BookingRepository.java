package com.workingtrio.workingtrio.repository;

import com.workingtrio.workingtrio.model.Booking;
import com.workingtrio.workingtrio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<List<Booking>> findByUserId(User userId);
}
