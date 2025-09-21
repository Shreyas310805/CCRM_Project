// FileName: MainMenu.java
package edu.ccrm.cli;

import edu.ccrm.config.AppConfig;
import edu.ccrm.domain.*;
import edu.ccrm.exception.DuplicateEnrollmentException;
import edu.ccrm.exception.MaxCreditLimitExceededException;
import edu.ccrm.io.BackupService;
import edu.ccrm.io.ImportExportService;
import edu.ccrm.service.*;
import edu.ccrm.util.InputValidator;
import edu.ccrm.util.RecursiveUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner;
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final TranscriptService transcriptService;
    private final ImportExportService importExportService;
    private final BackupService backupService;
    private final AppConfig appConfig;

    public MainMenu() {
        this.scanner = new Scanner(System.in);
        this.studentService = new StudentService();
        this.courseService = new CourseService();
        this.enrollmentService = new EnrollmentService(studentService, courseService);
        this.transcriptService = new TranscriptService();
        this.importExportService = new ImportExportService();
        this.backupService = new BackupService();
        this.appConfig = AppConfig.getInstance();
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleStudentManagement();
                    break;
                case "2":
                    handleCourseManagement();
                    break;
                case "3":
                    handleEnrollmentAndGrading();
                    break;
                case "4":
                    handleFileOperations();
                    break;
                case "5":
                    handleBackupOperations();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        System.out.println("Thank you for using CCRM. Goodbye!");
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n===== CCRM Main Menu =====");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Courses");
        System.out.println("3. Enrollment & Grading");
        System.out.println("4. Import/Export Data");
        System.out.println("5. Backup & Utilities");
        System.out.println("0. Exit");
        System.out.println("==========================");
    }

    private void handleStudentManagement() {
        System.out.println("\n--- Student Management ---");
        System.out.println("1. Add a new student");
        System.out.println("2. List all students");
        System.out.println("3. Generate a student transcript");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            System.out.print("Enter full name: ");
            String name = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter registration number: ");
            String regNo = scanner.nextLine();
            if (InputValidator.isNotNullOrEmpty(name) && InputValidator.isValidEmail(email) && InputValidator.isNotNullOrEmpty(regNo)) {
                studentService.addStudent(name, email, regNo);
                System.out.println("Student added successfully.");
            } else {
                System.out.println("Invalid input. Student not added.");
            }
        } else if ("2".equals(choice)) {
            System.out.println("\n--- List of All Students ---");
            studentService.getAllStudents().forEach(System.out::println);
        } else if ("3".equals(choice)) {
            try { // **FIXED: Added try-catch for NumberFormatException**
                System.out.print("Enter student ID to generate transcript: ");
                int id = Integer.parseInt(scanner.nextLine());
                Optional<Student> studentOpt = studentService.getStudentById(id);
                if (studentOpt.isPresent()) {
                    System.out.println(transcriptService.generateTranscript(studentOpt.get()));
                } else {
                    System.out.println("Student not found.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid ID. Please enter a number.");
            }
        }
    }

    private void handleCourseManagement() {
        System.out.println("\n--- Course Management ---");
        System.out.println("1. Add a new course");
        System.out.println("2. List all courses");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            try { // **FIXED: Added try-catch for NumberFormatException**
                System.out.print("Enter course code (e.g., CS101): ");
                String code = scanner.nextLine();
                System.out.print("Enter course title: ");
                String title = scanner.nextLine();
                System.out.print("Enter credits: ");
                int credits = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter department: ");
                String dept = scanner.nextLine();

                Course newCourse = new Course.CourseBuilder(code, title)
                        .withCredits(credits)
                        .withDepartment(dept)
                        .build();
                courseService.addCourse(newCourse);
                System.out.println("Course added successfully.");
            } catch (NumberFormatException e) {
                System.err.println("Invalid number for credits. Course not added.");
            }
        } else if ("2".equals(choice)) {
            System.out.println("\n--- List of All Courses ---");
            courseService.getAllCourses().forEach(System.out::println);
        }
    }

    private void handleEnrollmentAndGrading() {
        System.out.println("\n--- Enrollment & Grading ---");
        System.out.println("1. Enroll student in a course");
        System.out.println("2. Record a grade");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            try {
                System.out.print("Enter student ID: ");
                int studentId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter course code: ");
                String courseCode = scanner.nextLine();
                enrollmentService.enrollStudentInCourse(studentId, courseCode);
                System.out.println("Enrollment successful!");
            } catch (NumberFormatException e) {
                System.err.println("Invalid ID format.");
            } catch (DuplicateEnrollmentException | MaxCreditLimitExceededException e) {
                System.err.println("Enrollment Failed: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        } else if ("2".equals(choice)) {
            try { // **FIXED: Wrapped entire block in try-catch**
                System.out.print("Enter student ID: ");
                int studentId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter course code: ");
                String courseCode = scanner.nextLine();
                System.out.print("Enter grade (S, A, B, C, D, E, F): ");
                String gradeStr = scanner.nextLine().toUpperCase();

                Grade grade = Grade.valueOf(gradeStr);
                if (enrollmentService.recordGrade(studentId, courseCode, grade)) {
                    System.out.println("Grade recorded successfully.");
                } else {
                    System.out.println("Failed to record grade. Check student ID and course code.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid student ID. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid grade entered. Please use S, A, B, C, D, E, or F.");
            }
        }
    }

    private void handleFileOperations() {
        System.out.println("\n--- Import/Export Data ---");
        System.out.println("1. Import students from CSV");
        System.out.println("2. Export students to CSV");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        String dataDir = appConfig.getDataFolderPath();
        try {
            Files.createDirectories(Paths.get(dataDir));
        } catch (IOException e) {
            System.err.println("Could not create data directory: " + e.getMessage());
            return;
        }

        if ("1".equals(choice)) {
            String filePath = dataDir + "import_students.csv";
            System.out.println("Place your file at '" + filePath + "' with format: fullName,email,regNo");
            System.out.print("Press Enter to continue once the file is ready...");
            scanner.nextLine();
            try {
                List<Student> importedStudents = importExportService.importStudentsFromCSV(filePath);
                importedStudents.forEach(s -> studentService.addStudent(s.getFullName(), s.getEmail(), s.getRegNo()));
                System.out.println(importedStudents.size() + " students imported successfully.");
            } catch (IOException e) {
                System.err.println("Error importing file: " + e.getMessage());
            }
        } else if ("2".equals(choice)) {
            String filePath = dataDir + "export_students.csv";
            try {
                importExportService.exportStudentsToCSV(studentService.getAllStudents(), filePath);
                System.out.println("Students exported successfully to " + filePath);
            } catch (IOException e) {
                System.err.println("Error exporting file: " + e.getMessage());
            }
        }
    }

    private void handleBackupOperations() {
        System.out.println("\n--- Backup & Utilities ---");
        String sourceDir = appConfig.getDataFolderPath();
        String backupRootDir = "backups/";
        System.out.println("The current data directory is '" + sourceDir + "'.");
        System.out.print("Do you want to create a backup in '" + backupRootDir + "'? (y/n): ");
        String choice = scanner.nextLine();

        if ("y".equalsIgnoreCase(choice)) {
            try {
                Path backupPath = backupService.createBackup(sourceDir, backupRootDir);
                System.out.println("Backup created at: " + backupPath);
                long size = RecursiveUtils.calculateDirectorySize(backupPath);
                System.out.printf("Total size of backup directory: %.2f KB\n", size / 1024.0);
            } catch (IOException e) {
                System.err.println("Backup failed: " + e.getMessage());
            }
        }
    }
}