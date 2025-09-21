// FileName: CCRMApp.java
package edu.ccrm.cli;

/**
 * [cite_start]The main entry point for the Campus Course & Records Manager (CCRM) application[cite: 138].
 */
public class CCRMApp {

    /**
     * [cite_start]The main method that starts the application[cite: 140].
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // 1. Create an instance of MainMenu.
        MainMenu menu = new MainMenu();

        // 2. Call the start() method on that instance.
        menu.start();
    }
}