package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Grade;
import edu.ccrm.domain.Student;
import edu.ccrm.exception.DuplicateEnrollmentException;
import edu.ccrm.exception.MaxCreditLimitExceededException;

import java.util.NoSuchElementException;
import java.util.Optional;

public class EnrollmentService {

    private static final int MAX_CREDITS_PER_SEMESTER = 21;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    /**
     * Enrolls a student in a specific course after validating business rules.
     * @param studentId The ID of the student.
     * @param courseCode The code of the course.
     * @throws NoSuchElementException if the student or course is not found.
     * @throws DuplicateEnrollmentException if the student is already enrolled in the course.
     * @throws MaxCreditLimitExceededException if enrolling exceeds the semester credit limit.
     */
    public void enrollStudentInCourse(int studentId, String courseCode)
            throws DuplicateEnrollmentException, MaxCreditLimitExceededException {

        Student student = studentService.getStudentById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Student with ID " + studentId + " not found."));

        Course course = courseService.getCourseByCode(courseCode)
                .orElseThrow(() -> new NoSuchElementException("Course with code " + courseCode + " not found."));

        // Rule 1: Check for duplicate enrollment
        boolean isAlreadyEnrolled = student.getEnrollments().stream()
                .anyMatch(e -> e.getCourse().getCode().equalsIgnoreCase(courseCode));
        if (isAlreadyEnrolled) {
            throw new DuplicateEnrollmentException("Student " + student.getFullName() + " is already enrolled in course " + course.getTitle() + ".");
        }

        // Rule 2: Check for max credit limit
        int currentCredits = student.getEnrollments().stream()
                .mapToInt(e -> e.getCourse().getCredits())
                .sum();
        if (currentCredits + course.getCredits() > MAX_CREDITS_PER_SEMESTER) {
            throw new MaxCreditLimitExceededException("Cannot enroll. Exceeds max credit limit of " + MAX_CREDITS_PER_SEMESTER + " for the semester.");
        }

        // If all checks pass, create and add the enrollment
        Enrollment newEnrollment = new Enrollment(student, course);
        student.addEnrollment(newEnrollment);
    }

    /**
     * Records or updates a grade for a student's enrollment in a course.
     * @param studentId The ID of the student.
     * @param courseCode The code of the course.
     * @param grade The grade to assign.
     * @return true if the grade was successfully recorded, false otherwise (e.g., enrollment not found).
     */
    public boolean recordGrade(int studentId, String courseCode, Grade grade) {
        Optional<Student> studentOpt = studentService.getStudentById(studentId);
        if (studentOpt.isPresent()) {
            Optional<Enrollment> enrollmentOpt = studentOpt.get().getEnrollments().stream()
                    .filter(e -> e.getCourse().getCode().equalsIgnoreCase(courseCode))
                    .findFirst();

            if (enrollmentOpt.isPresent()) {
                enrollmentOpt.get().setGrade(grade);
                return true;
            }
        }
        return false;
    }
}