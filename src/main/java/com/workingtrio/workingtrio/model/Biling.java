package com.workingtrio.workingtrio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Biling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Facility facilityType;

    private Double price;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User userId;
    private LocalDateTime createdAt;
}
