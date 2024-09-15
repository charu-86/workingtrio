package com.workingtrio.workingtrio.repository;

import com.workingtrio.workingtrio.model.Payment;
import com.workingtrio.workingtrio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<List<Payment>> findByUserId(User userId);
}
