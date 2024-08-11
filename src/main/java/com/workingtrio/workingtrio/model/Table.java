package com.workingtrio.workingtrio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Table {
    @Id
    private Long id;

    @NotNull
    private boolean isAvailable;

    @NotNull
    @OneToOne
    private Facility type;

    @NotNull
    private int price;
}
