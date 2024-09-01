package com.workingtrio.workingtrio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String paymentMode;
    @ManyToOne
    private User userId;
    @ManyToOne
    private Biling billingID;
    private String status;
    private LocalDateTime createdAt;

}
