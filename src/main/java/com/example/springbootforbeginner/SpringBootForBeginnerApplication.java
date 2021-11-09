package com.example.springbootforbeginner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping(path = "aaa")
public class SpringBootForBeginnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootForBeginnerApplication.class, args);
    }

    @GetMapping
    public String getStudents(){
        return "hello";
//             return   studentService.getStudents();
    }
}
