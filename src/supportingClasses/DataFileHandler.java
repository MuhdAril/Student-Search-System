/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supportingClasses;

import studentManagementSystem.Student;
import studentManagementSystem.Module;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class DataFileHandler {

    public static List<Student> readStudents(String filename) {
        ArrayList<Student> students = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length < 4) continue; // Skip lines with insufficient data

            String className = parts[0];
            String adminNumber = parts[1];
            String name = parts[2];
            Student student = new Student(name, adminNumber, className);

            // Loop through modules, starting from the 5th element (index 4)
            for (int i = 4; i < parts.length; i += 4) {
                if (i + 3 >= parts.length) continue; // Ensure there's enough data for a module

                String moduleCode = parts[i];
                String moduleName = parts[i + 1];
                
                // Validate that creditUnit and marks are integers
                int creditUnit;
                double marks;
                try {
                    creditUnit = Integer.parseInt(parts[i + 2]);
                    marks = Double.parseDouble(parts[i + 3]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in data: " + e.getMessage());
                    continue;
                }

                Module module = new Module(moduleCode, moduleName, creditUnit, marks);
                student.addModule(module);
            }

            students.add(student);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return students;
    }
    
//    public void writeStudents(String students) {
//        
//    }
}
