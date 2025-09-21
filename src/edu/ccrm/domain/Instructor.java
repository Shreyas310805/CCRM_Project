// FileName: Instructor.java
package edu.ccrm.domain;

public class Instructor extends Person {
    private String department;
    private String specialization;

    public Instructor(int id, String fullName, String email, String department, String specialization) {
        super(id, fullName, email);
        this.department = department;
        this.specialization = specialization;
    }

    @Override
    public String getDetails() {
        return String.format(
                "Instructor Details:\n" +
                        "-------------------\n" +
                        "ID: %d\n" +
                        "Full Name: %s\n" +
                        "Email: %s\n" +
                        "Department: %s\n" +
                        "Specialization: %s\n",
                getId(), getFullName(), getEmail(), department, specialization
        );
    }

    @Override
    public String toString() {
        return String.format("Instructor[ID=%d, Name=%s, Dept=%s]", getId(), getFullName(), department);
    }

    // Getters and Setters
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}