package com.workingtrio.workingtrio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Tables")
@AllArgsConstructor
@NoArgsConstructor
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private boolean isAvailable;
}
