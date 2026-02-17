package com.student.management.service;

import com.student.management.dto.StudentPatchRequest;
import com.student.management.dto.StudentRequest;
import com.student.management.dto.StudentResponse;
import com.student.management.model.Student;
import com.student.management.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService{

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse createStudent(StudentRequest request) {

        Student student = new Student(
                request.getName(),
                request.getAge(),
                request.getCourse()
        );

        Student saved = studentRepository.save(student);

        return new StudentResponse(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getCourse()
        );
    }

    public List<StudentResponse> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(s -> new StudentResponse(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getCourse()
                ))
                .toList();
    }
    // ✅ GET student by ID
    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getCourse()
        );
    }
    public void deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student not found");
        }
            studentRepository.deleteById(id);
        }
    public StudentResponse patchStudent(Long id, StudentPatchRequest request){
         Student student = studentRepository.findById(id)
                 .orElseThrow(()-> new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND,
                "student Not found"));

        if (request.getName()  != null){
            student.setName(request.getName());
        }
        if (request.getAge() != null){
            student.setAge(request.getAge());
        }
        if(request.getCourse() != null){
            student.setCourse(request.getCourse());
        }
        Student saved = studentRepository.save(student);
        return new StudentResponse(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getCourse()
        );
    }
    }





