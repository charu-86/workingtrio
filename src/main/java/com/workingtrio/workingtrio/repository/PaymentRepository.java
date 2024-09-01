package com.workingtrio.workingtrio.repository;

import com.workingtrio.workingtrio.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
