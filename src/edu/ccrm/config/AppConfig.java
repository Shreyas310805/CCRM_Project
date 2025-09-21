// FileName: AppConfig.java
package edu.ccrm.config;

public class AppConfig {
    // A single, static final instance is created eagerly. [cite: 115]
    private static final AppConfig INSTANCE = new AppConfig();

    // Configuration fields [cite: 115]
    private String dataFolderPath;
    private int maxCreditsPerSemester;

    /**
     * The constructor is private to prevent instantiation from outside the class. [cite: 116]
     * It initializes default configuration values. [cite: 116]
     */
    private AppConfig() {
        // Initialize default values
        dataFolderPath = "data/";
        maxCreditsPerSemester = 21;
    }

    /**
     * Provides the single global instance of the AppConfig. [cite: 117]
     * @return The singleton instance of AppConfig.
     */
    public static AppConfig getInstance() {
        return INSTANCE; // [cite: 117]
    }

    // Standard getters and setters for configuration properties [cite: 117]

    public String getDataFolderPath() {
        return dataFolderPath;
    }

    public void setDataFolderPath(String dataFolderPath) {
        this.dataFolderPath = dataFolderPath;
    }

    public int getMaxCreditsPerSemester() {
        return maxCreditsPerSemester;
    }

    public void setMaxCreditsPerSemester(int maxCreditsPerSemester) {
        this.maxCreditsPerSemester = maxCreditsPerSemester;
    }
}