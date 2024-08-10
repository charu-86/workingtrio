package com.workingtrio.workingtrio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class UserType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String userType;
}
