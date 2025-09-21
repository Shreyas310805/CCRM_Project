package edu.ccrm.service;

import edu.ccrm.domain.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CourseService {
    private final List<Course> courses = new ArrayList<>();

    /**
     * Adds a new course to the in-memory list.
     * The course should be created using the Course.CourseBuilder.
     * @param course The course to add.
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Finds a course by its unique course code.
     * @param code The course code to search for.
     * @return An Optional containing the Course if found, or an empty Optional otherwise.
     */
    public Optional<Course> getCourseByCode(String code) {
        return courses.stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst();
    }

    /**
     * Retrieves a list of all courses.
     * @return A list containing all courses.
     */
    public List<Course> getAllCourses() {
        return new ArrayList<>(courses); // Return a copy
    }

    /**
     * Searches for courses using a given filter predicate.
     * @param filter The predicate to apply for filtering courses.
     * @return A list of courses that match the filter.
     */
    public List<Course> searchCourses(Predicate<Course> filter) {
        return courses.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}