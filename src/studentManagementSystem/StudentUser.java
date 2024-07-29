/**
 *
 * Member A:    Muhammad Aril Bin Mohamed Irwan (P2323275)
 * Member B:    See Yong Hong (P2323473) 
 * Class:       DIT/FT/2B/21
 *
 * Adaptations: 
 * windows-error.wav is adapted from: https://pixabay.com/sound-effects/search/windows/ 
 * winstart.wav is adapted from: https://www.winhistory.de/more/winstart/winstart_en.htm
 *
 */

package studentManagementSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentUser {

    public static void main(String[] args) {

        // Create students test
        StudentManagement.createStudent("John Tan", "P2312333", "DIT/FT/2A/01");
        StudentManagement.createStudent("Samsudin", "P2312555", "DIT/FT/2A/02");
        StudentManagement.createStudent("Jane Doe", "P2312777", "DIT/FT/2A/02");

        // Create modules test for John Tan
        Module mathModule = new Module("ST0509", "JPRG", 4, 85);
        Module programmingModule = new Module("ST0503", "FOP", 5, 78);

        // Add modules test to John Tan
        StudentManagement.addModuleToStudent("P2312333", mathModule);
        StudentManagement.addModuleToStudent("P2312333", programmingModule);

        // Create modules test for Samsudin
        Module mathModule1 = new Module("ST0509", "JPRG", 4, 78);
        Module programmingModule1 = new Module("ST0503", "FOP", 5, 85);

        // Add modules test to Samsudin
        StudentManagement.addModuleToStudent("P2312555", mathModule1);
        StudentManagement.addModuleToStudent("P2312555", programmingModule1);
        
        // Create modules test for Jane Doe
        Module mathModule2 = new Module("ST0509", "JPRG", 4, 40);
        Module programmingModule2 = new Module("ST0504", "FOP2", 5, 56);

        // Add modules test to Jane Doe
        StudentManagement.addModuleToStudent("P2312777", mathModule2);
        StudentManagement.addModuleToStudent("P2312777", programmingModule2);

        // Create buttons for the main menu
        JButton button1 = new JButton("Enquiry System");
        JButton button2 = new JButton("Admin System");

        // Add action listeners to the buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enquirySystem(); // Call the enquiry system
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminSystem(); // Call the admin system
            }
        });

        // Create a panel to hold the buttons
        JPanel panel = new JPanel();
        panel.add(button1);
        panel.add(button2);

        // Display the panel in a JOptionPane
        JOptionPane.showOptionDialog(
                null,
                panel,
                "Main menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{},
                null
        );
    }

    //Enquiry System by Member A
    public static void enquirySystem() {

        while (true) {

            // Display the enquiry system options
            String optionInput = JOptionPane.showInputDialog(null,
                    "Enter your option:\n\n"
                    + "1. Display all students\n"
                    + "2. Search student by class\n"
                    + "3. Search student by name\n"
                    + "4. Quit",
                    "Student Enquiry System",
                    JOptionPane.QUESTION_MESSAGE);

            try {

                int option = Integer.parseInt(optionInput);

                switch (option) {
                    case 1: // Display all students

//                        StudentManagement.displayAllStudents();
                        break;

                    case 2: // Search students in class

                        while (true) {

                            String className = JOptionPane.showInputDialog(null, "Enter the class name to search:", "Search", JOptionPane.QUESTION_MESSAGE);

                            if (!className.equals("")) {
                                // Search for the class if the input is not empty
                                StudentManagement.searchClass(className);
                                break;
                            } else {
                                // Play error sound and show error message if the input is empty
                                supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
                                new Thread(() -> sound.playSound("resources/windows-error.wav")).start();
                                
                                JOptionPane.showMessageDialog(null, "Please enter a class!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;

                    case 3: // Search student by name

                        while (true) {
                            String studentName = JOptionPane.showInputDialog(null, "Enter the Student name to search:", "Student Info", JOptionPane.QUESTION_MESSAGE);

                            if (!studentName.equals("")) {
                                // Search for the student if the input is not empty
                                StudentManagement.searchStudent(studentName);
                                break;
                            } else {
                                // Play error sound and show error message if the input is empty
                                supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
                                new Thread(() -> sound.playSound("resources/windows-error.wav")).start();
                                
                                JOptionPane.showMessageDialog(null, "Please enter a name!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;

                    case 4: // Quit the enquiry system
                        
                        JOptionPane.showMessageDialog(
                                null, "Program terminated. \nThank You!",
                                "Message", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);

                    default: // Play error sound and show error message if the input is not 1 to 4

                        supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
                        new Thread(() -> sound.playSound("resources/windows-error.wav")).start();

                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter option 1 to 4.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) { // Play error sound and show error message if the input is not a number

                supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
                new Thread(() -> sound.playSound("resources/windows-error.wav")).start();

                JOptionPane.showMessageDialog(null, "Invalid input. Please enter option 1 to 4.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    //Admin System by Member B
    public static void adminSystem() {

        while (true) {

            // Display the enquiry system options
            String inputString = JOptionPane.showInputDialog(null, "Enter your option: \n \n 1. Add new student \n 2. Delete student \n 3. Add new module for student \n 4. Quit",
                    "Student Admin System", JOptionPane.QUESTION_MESSAGE);

            try {

                int input = Integer.parseInt(inputString);

                switch (input) {
                    case 1: //Add a student

                        // Get student details
                        String inputName = JOptionPane.showInputDialog(null, "Enter name:",
                                "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                        String inputAdmin = JOptionPane.showInputDialog(null, "Enter Admin:",
                                "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                        String inputClass = JOptionPane.showInputDialog(null, "Enter Class:",
                                "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                        // Create a new student
                        StudentManagement.createStudent(inputName, inputAdmin, inputClass);
                        // Get the number of modules the student is taking
                        String inputModuleNo = JOptionPane.showInputDialog(null, "Enter number of Modules Taken:",
                                "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                        int totalModule = Integer.parseInt(inputModuleNo);

                        // Loop to get details of each module
                        for (int i = 0; i < totalModule; i++) {
                            String moduleCode = JOptionPane.showInputDialog(null, "Enter Module Code for module " + (i + 1) + ":",
                                    "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                            String moduleName = JOptionPane.showInputDialog(null, "Enter Module Name for module " + (i + 1) + ":",
                                    "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                            String creditUnitStr = JOptionPane.showInputDialog(null, "Enter Credit Unit for module " + (i + 1) + ":",
                                    "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                            int creditUnit = Integer.parseInt(creditUnitStr);
                            String moduleMarksStr = JOptionPane.showInputDialog(null, "Enter Module Marks for module " + (i + 1) + ":",
                                    "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                            int moduleMarks = Integer.parseInt(moduleMarksStr);
                            // Create a new module and add it to the student
                            Module module = new Module(moduleCode, moduleName, creditUnit, moduleMarks);
                            StudentManagement.addModuleToStudent(inputAdmin, module);
                        }
                        break;

                    case 2: //Delete a student

                        // Get admin number of the student to be deleted
                        String inputDelete = JOptionPane.showInputDialog(null, "Enter admin number of student:",
                                "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                        StudentManagement.deleteStudent(inputDelete.trim());
                        break;

                    case 3: //Add new module for a student

                        // Get admin number of the student
                        String inputAddModule = JOptionPane.showInputDialog(null, "Enter admin number of student:",
                                "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                        // Get module details
                        String moduleCode = JOptionPane.showInputDialog(null, "Enter Module Code for module:",
                                "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                        String moduleName = JOptionPane.showInputDialog(null, "Enter Module Name for module:",
                                "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                        String creditUnitStr = JOptionPane.showInputDialog(null, "Enter Credit Unit for module:",
                                "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                        int creditUnit = Integer.parseInt(creditUnitStr);
                        String moduleMarksStr = JOptionPane.showInputDialog(null, "Enter Module Marks for module:",
                                "Student Admin System", JOptionPane.QUESTION_MESSAGE);
                        int moduleMarks = Integer.parseInt(moduleMarksStr);
                        // Create a new module and add it to the student
                        Module module = new Module(moduleCode, moduleName, creditUnit, moduleMarks);
                        StudentManagement.addModuleToStudent(inputAddModule, module);
                        break;

                    case 4: //Quit the program

                        JOptionPane.showMessageDialog(
                                null, "Program terminated. \nThank You!",
                                "Message", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    default: // Play error sound and show error message
                        supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
                        new Thread(() -> sound.playSound("resources/windows-error.wav")).start();

                        JOptionPane.showMessageDialog(
                                null, "Invalid input. Please try again.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        break;

                }
            } catch (NumberFormatException e) { // Play error sound and show error message

                supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
                new Thread(() -> sound.playSound("resources/windows-error.wav")).start();

                JOptionPane.showMessageDialog(null, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
}
