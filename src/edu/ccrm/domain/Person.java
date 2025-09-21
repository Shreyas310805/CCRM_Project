// FileName: Person.java
package edu.ccrm.domain;

/**
 * An abstract base class for Student and Instructor, containing common properties. [cite: 155]
 */
public abstract class Person {

    private int id;
    private String fullName;
    private String email;

    /**
     * Protected constructor to be called by subclasses. [cite: 157]
     * @param id The unique identifier.
     * @param fullName The full name.
     * @param email The email address.
     */
    protected Person(int id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    /**
     * An abstract method to be implemented by subclasses to return formatted details. [cite: 159]
     * @return A string with detailed information.
     */
    public abstract String getDetails();

    // Standard Getters and Setters [cite: 160]

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}