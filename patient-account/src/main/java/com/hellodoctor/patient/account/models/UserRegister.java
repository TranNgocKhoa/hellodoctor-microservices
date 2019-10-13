package com.hellodoctor.patient.account.models;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
