package main.artfix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Utility class for file operations
 * Handles reading and writing game-related files
 */
public class FileIng {
    public static String ReadData = null;
    
    /**
     * Read content from a file in the app_files directory
     * @param fileName name of the file (without .txt extension)
     */
    public static void read(String fileName) {
        ReadData = null; // Reset previous data
        
        try {
            File file = new File("app_files/" + fileName + ".txt");
            if (!file.exists()) {
                return; // File doesn't exist, leave ReadData as null
            }
            
            try (Scanner scanner = new Scanner(file)) {
                if (scanner.hasNextLine()) {
                    ReadData = scanner.nextLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Warning: Could not read file: " + fileName);
            // Don't crash the game for file read errors
        }
    }
    
    /**
     * Write content to a file in the app_files directory
     * @param fileName name of the file (without .txt extension)
     * @param content content to write to the file
     */
    public static void write(String fileName, String content) {
        try {
            // Create directory if it doesn't exist
            File directory = new File("app_files");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            
            try (FileWriter writer = new FileWriter("app_files/" + fileName + ".txt")) {
                writer.write(content);
            }
        } catch (IOException e) {
            System.err.println("Warning: Could not write to file: " + fileName);
            // Don't crash the game for file write errors
        }
    }
}
