package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Grade;
import edu.ccrm.domain.Student;

public class TranscriptService {

    /**
     * Calculates the Grade Point Average (GPA) for a given student.
     * GPA = (Sum of [Credit * Grade Point]) / (Total Credits)
     * @param student The student for whom to calculate the GPA.
     * @return The calculated GPA as a double. Returns 0.0 if there are no graded credits.
     */
    public double calculateGPA(Student student) {
        int totalCredits = 0;
        double totalPoints = 0.0;

        for (Enrollment enrollment : student.getEnrollments()) {
            Grade grade = enrollment.getGrade();
            int credits = enrollment.getCourse().getCredits();

            if (grade != null && credits > 0) {
                totalCredits += credits;
                totalPoints += (grade.getGradePoint() * credits);
            }
        }

        if (totalCredits == 0) {
            return 0.0; // Avoid division by zero
        }

        return totalPoints / totalCredits;
    }

    /**
     * Generates a formatted string representing a student's academic transcript.
     * @param student The student whose transcript is to be generated.
     * @return A formatted string containing transcript details.
     */
    public String generateTranscript(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append("****************************************\n");
        sb.append("      ACADEMIC TRANSCRIPT\n");
        sb.append("****************************************\n\n");
        sb.append(String.format("Student Name: %s\n", student.getFullName()));
        sb.append(String.format("Registration No: %s\n", student.getRegNo()));
        sb.append(String.format("Status: %s\n\n", student.getStatus()));
        sb.append("-----------------------------------------------------------------\n");
        sb.append(String.format("%-10s %-35s %-10s %-10s\n", "Course", "Title", "Credits", "Grade"));
        sb.append("-----------------------------------------------------------------\n");

        if (student.getEnrollments().isEmpty()) {
            sb.append("No courses enrolled.\n");
        } else {
            for (Enrollment e : student.getEnrollments()) {
                String gradeStr = (e.getGrade() != null) ? e.getGrade().toString() : "Pending";
                sb.append(String.format("%-10s %-35s %-10d %-10s\n",
                        e.getCourse().getCode(),
                        e.getCourse().getTitle(),
                        e.getCourse().getCredits(),
                        gradeStr));
            }
        }

        sb.append("-----------------------------------------------------------------\n");
        double gpa = calculateGPA(student);
        sb.append(String.format("\nCumulative GPA: %.2f\n", gpa));
        sb.append("****************************************\n");

        return sb.toString();
    }
}