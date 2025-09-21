// FileName: BackupService.java
package edu.ccrm.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class BackupService {

    /**
     * Creates a full backup of a source directory into a new, timestamped sub-directory
     * within a specified backup root location.
     *
     * @param sourceDir     The path of the directory to back up (e.g., "data/exports").
     * @param backupRootDir The path of the root directory where backups are stored (e.g., "data/backups").
     * @return The path to the newly created timestamped backup directory.
     * @throws IOException If an I/O error occurs during the backup process.
     */
    public Path createBackup(String sourceDir, String backupRootDir) throws IOException {
        // 1. Define the source and backup root paths
        Path sourcePath = Paths.get(sourceDir);
        Path backupRootPath = Paths.get(backupRootDir);

        // 2. Create a timestamped folder name
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String backupFolderName = "backup-" + timestamp;

        // 3. Create the full path for the new backup directory
        Path backupDestinationPath = backupRootPath.resolve(backupFolderName);
        Files.createDirectories(backupDestinationPath);

        // 4. Walk the source directory and copy files to the destination
        try (Stream<Path> walk = Files.walk(sourcePath)) {
            walk.forEach(source -> {
                try {
                    // Resolve the destination path for each file/directory
                    Path destination = backupDestinationPath.resolve(sourcePath.relativize(source));

                    // Copy the file, replacing it if it somehow already exists
                    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    // It's better to wrap this in a custom runtime exception or handle it more gracefully
                    System.err.println("Failed to copy " + source + ": " + e.getMessage());
                }
            });
        }

        System.out.println("Backup created successfully at: " + backupDestinationPath);
        return backupDestinationPath;
    }
}