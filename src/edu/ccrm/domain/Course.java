// FileName: Course.java
package edu.ccrm.domain;

public class Course {
    private String code;
    private String title;
    private int credits;
    private Instructor instructor;
    private Semester semester;
    private String department;

    // Private constructor to be called only by the builder
    private Course(CourseBuilder builder) {
        this.code = builder.code;
        this.title = builder.title;
        this.credits = builder.credits;
        this.instructor = builder.instructor;
        this.semester = builder.semester;
        this.department = builder.department;
    }

    @Override
    public String toString() {
        return String.format("Course[Code=%s, Title=%s, Credits=%d]", code, title, credits);
    }

    // Only getters to ensure immutability
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Semester getSemester() {
        return semester;
    }

    public String getDepartment() {
        return department;
    }

    /**
     * The static nested builder class for creating Course instances.
     */
    public static class CourseBuilder {
        // Required parameters
        private final String code;
        private final String title;

        // Optional parameters - initialized to default values
        private int credits = 0;
        private Instructor instructor = null;
        private Semester semester = null;
        private String department = "General";

        public CourseBuilder(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public CourseBuilder withCredits(int credits) {
            this.credits = credits;
            return this;
        }

        public CourseBuilder withInstructor(Instructor instructor) {
            this.instructor = instructor;
            return this;
        }

        public CourseBuilder withSemester(Semester semester) {
            this.semester = semester;
            return this;
        }

        public CourseBuilder withDepartment(String department) {
            this.department = department;
            return this;
        }


        public Course build() {
            return new Course(this);
        }
    }
}