/**
 *
 * Member A:    Muhammad Aril Bin Mohamed Irwan (P2323275)
 * Member B:    See Yong Hong (P2323473)
 * Class:       DIT/FT/2B/21
 *
 */
package studentManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String className;
    private String adminNumber;
    private String name;
    private double gpa;
    private List<Module> modules;

    //Constructor
    public Student(String name, String adminNumber, String className) {
        this.className = className;
        this.adminNumber = adminNumber;
        this.name = name;
        this.modules = new ArrayList<>();
        this.gpa = 0;
    }

    /*
     ********* Getters & Setters **********
     */
    //Member A Start
    public String getClassName() {
        return className;
    }

    public String getAdminNumber() {
        return adminNumber;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return calculateGPA();
    }

    public List<Module> getModules() {
        return modules;
    }

    public String getModulesString() {
        String moduleList = "";
        char grade;

        if (!modules.isEmpty()) {
            // Find the grade character based on the grade point of the first module
            grade = Module.findGrade((modules.get(0)).getGradePoint());

            // Construct a string representation of the first module details and grade
            moduleList = (modules.get(0)).getModuleCode() + "/" + (modules.get(0)).getModuleName() + "/" + (modules.get(0)).getCreditUnit() + ": " + grade + "\n";
        }
        return moduleList;
    }

    //Member A End
    //Member B Start
    public void addModule(Module module) {
        this.modules.add(module);
    }

    //Member B End
    /*
     ********* Enquiry System Operation Methods **********
     */
    // Method to calculate GPA based on modules' credit units and grade points
    private double calculateGPA() {
        double totalCreditUnits = 0;
        double totalWeightedPoints = 0;

        // Loop through each module in the list
        for (int i = 0; i < modules.size(); i++) {

            // Accumulate total credit units
            totalCreditUnits += modules.get(i).getCreditUnit();

            // Accumulate total weighted grade points (credit units * grade point)
            totalWeightedPoints += modules.get(i).getCreditUnit() * modules.get(i).getGradePoint();
        }

        // Calculate GPA if total credit units are not zero
        if (totalCreditUnits != 0) {
            gpa = totalWeightedPoints / totalCreditUnits;
        } else {
            gpa = 0;
        }

        return gpa;
    }
}
