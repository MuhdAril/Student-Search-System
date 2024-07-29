/**
 *
 * Member A:    Muhammad Aril Bin Mohamed Irwan (P2323275)
 * Member B:    See Yong Hong (P2323473)
 * Class:       DIT/FT/2B/21
 * 
 */

package studentManagementSystem;


public class Module {

    private String moduleCode;
    private String moduleName;
    private int creditUnit;
    private double marks;

    //Constructor
    public Module(String moduleCode, String moduleName, int creditUnit, double marks) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.creditUnit = creditUnit;
        this.marks = marks;
    }

    /*
     ********* Getters & Setters **********
     */
    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getCreditUnit() {
        return creditUnit;
    }
    
    public double getMarks() {
        return marks;
    }

    public int getGradePoint() {
        int gradePoint;

        if (marks >= 80) {
            gradePoint = 4;
        } else if (marks >= 70) {
            gradePoint = 3;
        } else if (marks >= 60) {
            gradePoint = 2;
        } else if (marks >= 50) {
            gradePoint = 1;
        } else {
            gradePoint = 0;
        }
        return gradePoint;
    }
    
    // Method to determine the grade based on point
    public static char findGrade(int gradePoint) {
        char gradechar;

        //Assign grade character based on grade point
        switch (gradePoint) {
            case 4:
                gradechar = 'A';
                break;
            case 3:
                gradechar = 'B';
                break;
            case 2:
                gradechar = 'C';
                break;
            case 1:
                gradechar = 'D';
                break;
            default:
                gradechar = 'F';
        }

        return gradechar;
    }
}
