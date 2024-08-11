package com.workingtrio.workingtrio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Room {
    @Id
    private Long id;

    @NotNull
    private int number;

    @NotNull
    @OneToOne
    private Facility type;

    @NotNull
    private boolean isAvailable;
}
