// FileName: Student.java
package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student extends Person {
    private String regNo;
    private String status;
    private List<Enrollment> enrollments;
    private LocalDate creationDate;

    public Student(int id, String fullName, String email, String regNo) {
        super(id, fullName, email);
        this.regNo = regNo;
        this.status = "ACTIVE";
        this.enrollments = new ArrayList<>();
        this.creationDate = LocalDate.now();
    }

    @Override
    public String getDetails() {
        String enrolledCourses = enrollments.isEmpty() ? "None" :
                enrollments.stream()
                        .map(e -> e.getCourse().getTitle())
                        .collect(Collectors.joining(", "));

        return String.format(
                "Student Details:\n" +
                        "----------------\n" +
                        "ID: %d\n" +
                        "Full Name: %s\n" +
                        "Email: %s\n" +
                        "Registration No: %s\n" +
                        "Status: %s\n" +
                        "Profile Created On: %s\n" +
                        "Enrolled Courses: %s\n",
                getId(), getFullName(), getEmail(), regNo, status, creationDate, enrolledCourses
        );
    }

    /**
     * Adds an enrollment record to the student's list of enrollments.
     * @param enrollment The enrollment to add.
     */
    public void addEnrollment(Enrollment enrollment) {
        this.enrollments.add(enrollment);
    }

    @Override
    public String toString() {
        return String.format("Student[ID=%d, Name=%s, RegNo=%s]", getId(), getFullName(), regNo);
    }

    // Getters and Setters
    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}