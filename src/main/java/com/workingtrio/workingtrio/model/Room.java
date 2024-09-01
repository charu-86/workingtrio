package com.workingtrio.workingtrio.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private int number;

    @NotBlank
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User userID;

    @NotBlank
    private boolean isAvailable;
}
