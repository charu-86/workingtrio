package com.workingtrio.workingtrio.repository;

import com.workingtrio.workingtrio.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
