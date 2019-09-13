package com.hellodoctor.dummy.controllers;

import com.hellodoctor.dummy.models.Student;
import com.hellodoctor.dummy.services.DummyResourceService;
import com.hellodoctor.dummy.services.PropertiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DummyController {

    @Autowired
    private DummyResourceService dummyResourceService;

    @Autowired
    private PropertiesMapper propertiesMapper;

    @GetMapping("/")
    public Mono<String> greeting(String name) {
        propertiesMapper.readProperty();
        return Mono.just("Hello, " + name);
    }


    @GetMapping("/student")
    public Flux<Student> getListStudent() {
        return Flux.fromIterable(dummyResourceService.getStudents());
    }
}
