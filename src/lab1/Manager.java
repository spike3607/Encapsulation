/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mschoenauer1
 */
public class Manager {
    private Employee employee;
    private String firstName;
    private String lastName;
    private String ssn;

//    public Manager(String firstName, String lastName, String ssn) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.ssn = ssn;
    
    public Manager() {
    }
    
    public String getStatus() {
        return employee.getStatus();
    }

//    }
    public void hireEmployee(String newEmployeeFirstName, String newEmployeeLastName, String newEmployeeSSN, String newEmployeeCubicle) {
       employee = new Employee(newEmployeeFirstName, newEmployeeLastName, newEmployeeSSN, newEmployeeCubicle);
        
        meetWithHrForBenefitAndSalryInfo(employee);
        meetDepartmentStaff(employee);
        reviewDeptPolicies(employee);
        moveIntoCubicle(employee);
        
    }
    
    private String formatDate() {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(currentDate);
        return fmtDate;
    }
    
    // Assume this must be performed first
    private void meetWithHrForBenefitAndSalryInfo(Employee newEmployee) {

        System.out.println("Met with Hr on " + formatDate());
        newEmployee.setMetWithHr(true);
    }
    
    // Assume this is must be performed second
    private void meetDepartmentStaff(Employee newEmployee) {
        if(newEmployee.isMetWithHr()) {
            System.out.println("Met with Dept. Staff on " + formatDate());
            newEmployee.setMetDeptStaff(true);
        } else {
            System.out.println("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }
    
    // Assume this must be performed third
    private void reviewDeptPolicies(Employee newEmployee) {
        if(newEmployee.isMetWithHr() && newEmployee.isMetDeptStaff()) {
            System.out.println("Reviewed Dept. Policies on " + formatDate());
            newEmployee.setReviewedDeptPolicies(true);
        } else {
            System.out.println("Sorry, you cannot review "
                    + " department policies until you have first met with HR "
                    + "and then with department staff.");
        }
    }
    
    // Assume this must be performed 4th
    private void moveIntoCubicle(Employee newEmployee) {
        if(newEmployee.isMetWithHr() && newEmployee.isMetDeptStaff() && newEmployee.isReviewedDeptPolicies()) {
            System.out.println("Moved into cube on " + formatDate());
            newEmployee.setMovedIn(true);
        } else {
            System.out.println("Sorry, you cannot move in to a "
                    + "cubicle until you have first met with HR "
                    + "and then with department staff, and then reviewed"
                    + "department policies.");
        }

    }
}
