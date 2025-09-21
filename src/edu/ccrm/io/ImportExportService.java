// FileName: ImportExportService.java
package edu.ccrm.io;

import edu.ccrm.domain.Student;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImportExportService {

    /**
     * Imports students from a specified CSV file.
     * Assumes the CSV format is: fullName,email,regNo (without a header).
     * The ID for the created Student objects will be a placeholder (0) and should be
     * properly assigned when added to the StudentService.
     *
     * @param filePath The path to the CSV file.
     * @return A list of Student objects parsed from the file.
     * @throws IOException If an I/O error occurs reading from the file.
     */
    public List<Student> importStudentsFromCSV(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length >= 3)
                    .map(parts -> new Student(0, parts[0].trim(), parts[1].trim(), parts[2].trim())) // Using 0 as placeholder ID
                    .collect(Collectors.toList());
        }
    }

    /**
     * Exports a list of students to a specified CSV file.
     * Writes a header row: id,fullName,email,regNo.
     *
     * @param students The list of students to export.
     * @param filePath The path of the file to write to.
     * @throws IOException If an I/O error occurs writing to the file.
     */
    public void exportStudentsToCSV(List<Student> students, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            // Write header
            writer.write("id,fullName,email,regNo\n");
            // Write student data
            for (Student student : students) {
                String line = String.join(",",
                        String.valueOf(student.getId()),
                        student.getFullName(),
                        student.getEmail(),
                        student.getRegNo()
                );
                writer.write(line + "\n");
            }
        }
    }
}