/**
 *
 * Member A:    Muhammad Aril Bin Mohamed Irwan (P2323275)
 * Member B:    See Yong Hong (P2323473)
 * Class:       DIT/FT/2B/21
 *
 * Adaptations: windows-error.wav is adapted from: https://pixabay.com/sound-effects/search/windows/
 *              winstart.wav is adapted from: https://www.winhistory.de/more/winstart/winstart_en.htm
 *
 */
package studentManagementSystem;

import supportingClasses.DataFileHandler;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class StudentManagement {

    private static List<Student> students = new ArrayList<>();

    //Constructor
    public StudentManagement() {
        this.students = new ArrayList<>();
    }
    
    // Method to load students from a file
    public static void loadStudents(String filename) {
        students = DataFileHandler.readStudents(filename);
    }


    /*
     ******************************************* Member A ***********************************************
     */
    // Method to display all students
    public static List<Student> getAllStudents() {
        return students;
    }

    // Method to search for number of students in class with average GPA
    public static String searchClass(String className) {
        int count = 0;
        double totalGPA = 0.0;
        String searchResult;
        Student firstStudentInClass = null;

        for (Student student : students) {
            if (student.getClassName().equalsIgnoreCase(className)) {
                count++;
                totalGPA += student.getGPA();
                if (firstStudentInClass == null) {
                    firstStudentInClass = student;
                }
            }
        }

        if (count > 0) {
            double averageGPA = totalGPA / count;

            // Play success sound
            supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
            new Thread(() -> sound.playSound("resources/winstart.wav")).start();

            searchResult = "Number of student(s) in " + className + ": " + count + "\nAverage GPA: " + String.format("%.2f", averageGPA);

            if (firstStudentInClass != null) {
                searchResult += "\n------------------\n\nFirst student in class:\n" + printStatisticsForSingleStudent(firstStudentInClass);
            }
            return searchResult;
        } else {
            // Play error sound
            supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
            new Thread(() -> sound.playSound("resources/windows-error.wav")).start();

            return "No student found from class!";
        }
    }

    // Method to search for a student by name
    public static String searchStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                String studentStatistics = printStatisticsForSingleStudent(student);

                // Play success sound
                supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
                new Thread(() -> sound.playSound("resources/winstart.wav")).start();

                return studentStatistics + "\nGPA: " + String.format("%.2f", student.getGPA()) + "\n------------------";
            }
        }

        // Play error sound
        supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
        new Thread(() -> sound.playSound("resources/windows-error.wav")).start();

        return "No such student found";
    }

    // Method to print statistics for a single student
    private static String printStatisticsForSingleStudent(Student student) {
        return "Name: " + student.getName() + "\n"
                + "Admin: " + student.getAdminNumber() + "\n"
                + "Class: " + student.getClassName() + "\n\n"
                + student.getName() + "'s 1st Module Taken: \n" + student.getModulesString();
    }

    /*
     *************************************** Member B *********************************************
     */
    // Method to create a new student
    public static void createStudent(String name, String adminNumber, String className) {
        //add details from input
        Student student = new Student(name, adminNumber, className);

        students.add(student);

        // winastart.wav sound will be played when successful
        supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
        new Thread(() -> sound.playSound("resources/winstart.wav")).start();

    }

    // Method to add a module to a student
    public static void addModuleToStudent(String adminNumber, Module module) {
        // Check through all students to find the student with the matching admin number
        for (Student student : students) {
            if (student.getAdminNumber().equals(adminNumber)) {
                //adds the module to student if the input matches the student's admin number
                student.addModule(module);

                // winastart.wav sound will be played when successful
                supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
                new Thread(() -> sound.playSound("resources/winstart.wav")).start();

                return;
            }
        }

        //Error sound will be played when there are no students with the inputted name
        supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
        new Thread(() -> sound.playSound("resources/windows-error.wav")).start();

        JOptionPane.showMessageDialog(null, "Student not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to delete a student
    public static void deleteStudent(String adminNumber) {
        // Check through all students to find the student with the matching admin number
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAdminNumber().equalsIgnoreCase(adminNumber)) {
                //remove student from students list if the input matches the student's admin number
                students.remove(i);

                // winastart.wav sound will be played when successful
                supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
                new Thread(() -> sound.playSound("resources/winstart.wav")).start();

                JOptionPane.showMessageDialog(null, "Student deleted!", "Student Admin System", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
        //Error sound will be played when there are no students aith the inputed name
        supportingClasses.SoundPlayer sound = new supportingClasses.SoundPlayer();
        new Thread(() -> sound.playSound("resources/windows-error.wav")).start();

        JOptionPane.showMessageDialog(null, "Student not found!", "Student Admin System", JOptionPane.ERROR_MESSAGE);
    }
}
