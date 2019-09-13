package com.hellodoctor.dummy.services;

import com.hellodoctor.dummy.models.Student;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties(prefix = "dummy")
@EnableConfigurationProperties
public class DummyResourceService {

    private List<Student> students;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }
}
