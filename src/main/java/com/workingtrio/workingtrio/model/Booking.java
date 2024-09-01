package com.workingtrio.workingtrio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User userId;

    @ManyToOne
    private Facility facilityType;

    private LocalDateTime bookingDateTime;

    private LocalDateTime checkoutDateTime;

}
