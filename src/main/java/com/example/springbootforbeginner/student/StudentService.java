package com.example.springbootforbeginner.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
//        return Arrays.asList(new Student(1l, "lulu", "lulu.lin@gmail.com", LocalDate.of(2000, Month.JANUARY, 5), 21));
          return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
//        System.out.println(student);
        Optional<Student> studentEmailExist = studentRepository.findStudentyByEmail(student.getEmail());
        if (studentEmailExist.isPresent()){
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
//        studentRepository.findById(studentId);
       boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("student with id "+studentId+" does not exist.");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional // use setters to update the fields without any queries
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id "+ studentId +" does not exist."));
        if (name != null && name.length() >0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if (email != null && email.length() >0 && !Objects.equals(student.getEmail(), email)){
            student.setEmail(email);
        }

//        studentRepository.save(student);
    }
}
