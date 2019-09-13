package com.hellodoctor.dummy.models;

import lombok.Data;

@Data(staticConstructor = "of")
public class Student {
    private String name;
    private int yearOfBirth;
}
