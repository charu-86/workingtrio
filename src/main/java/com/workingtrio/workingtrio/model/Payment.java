package com.workingtrio.workingtrio.model;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String paymentMode;
    @ManyToOne
    @JoinColumn(name = "User_id")
    private User userId;
    @ManyToOne
    private Biling billingID;
    private String status;
    private LocalDateTime createdAt;

}
