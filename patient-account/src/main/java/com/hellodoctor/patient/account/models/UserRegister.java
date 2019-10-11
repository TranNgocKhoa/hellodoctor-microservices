package com.hellodoctor.patient.account.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserRegister {
    private Long id;
    private String username;
    private String name;
    private String email;
    private String phoneNumber;
    private String avatarImg;
    private LocalDate dateOfBirth;
    private Gender gender;
}
