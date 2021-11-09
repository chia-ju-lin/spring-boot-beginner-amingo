package com.example.springbootforbeginner.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student lulu = new Student(1l, "lulu", "lulu.lin@gmail.com", LocalDate.of(2000, Month.JANUARY, 5));
            Student Tobi = new Student(2l, "toby", "toby.lin@gmail.com", LocalDate.of(2004, Month.JANUARY, 15));
            repository.saveAll(Arrays.asList(lulu,Tobi));
        };
    }

}
