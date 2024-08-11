package com.workingtrio.workingtrio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;

@Entity
public class Facility {
    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private boolean isAvailable;

    @Transient
    private int quantity;

}
