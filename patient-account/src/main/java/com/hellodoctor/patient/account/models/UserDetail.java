package com.hellodoctor.patient.account.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDetail {
    private Long id;
    private String username;
    private String name;
    private String email;
    private String phoneNumber;
    private String avatarImg;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String description;
    private String personIdNumber;
    private String address;
    private Float height;
    private Float weight;
}
