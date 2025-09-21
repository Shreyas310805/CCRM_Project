package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private int nextId = 1;


    public Student addStudent(String fullName, String email, String regNo) {
        Student newStudent = new Student(nextId++, fullName, email, regNo);
        students.add(newStudent);
        return newStudent;
    }


    public boolean updateStudent(int id, String newFullName, String newEmail) {
        Optional<Student> studentOpt = getStudentById(id);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setFullName(newFullName);
            student.setEmail(newEmail);
            return true;
        }
        return false;
    }


    public Optional<Student> getStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    /**
     * Retrieves a list of all students.
     * @return A new list containing all students.
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Return a copy
    }
}