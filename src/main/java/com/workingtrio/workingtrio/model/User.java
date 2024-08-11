package com.workingtrio.workingtrio.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

import java.util.List;


@Entity
@Table (name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String userName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String mobNo;

    private boolean isAdmin;
    private boolean isStaff;
    private boolean isGuest;

}
