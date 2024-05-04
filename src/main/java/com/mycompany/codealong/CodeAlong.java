
package com.mycompany.codealong;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CodeAlong {

    public static void main(String[] args) throws IOException, CsvException {
          Employee _emp = new Employee();
          deductions _Ded = new deductions();
          WorkHoursCalc _calc = new WorkHoursCalc();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Employee No.: ");
            String employeeNo = sc.nextLine();
        try {
            _emp = _emp.GetEmployee(employeeNo); 
            _Ded = _Ded.GetDeductions(employeeNo);
        } 
        
        catch (IOException | CsvValidationException ex) {
            Logger.getLogger(CodeAlong.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    System.out.println(" ");    
    System.out.println("******************************");
    System.out.println("EMPLOYEE INFORMATION");
    System.out.println("Employee No.:" + _emp.getEmployeenumber());
    System.out.println("Last Name: " + _emp.getlastName());
    System.out.println("First Name: " + _emp.getFirstname());
    System.out.println("Address: " + _emp.getAddress());
    System.out.println("Phone No.:  " + _emp.getContactInfo());
    System.out.println("Birthdate:  " + _emp.getBirthday());
    System.out.println("Position: " + _emp.getPosition());
    System.out.println("Immediate Supervisor: " + _emp.getImmediateSupervisor());
    System.out.println("Status: " + _emp.getStatus());
    
    System.out.println(" ");
    System.out.println("SALARY AND ALLOWANCES");
    System.out.println("Basic Salary: " + _Ded.getBasicsalary());
    System.out.println("Rice Subsidy: " + _Ded.getriceSubsidy());
    System.out.println("Phone Allowance: " + _Ded.getphoneAllowance());
    System.out.println("Clothing Allowance: " + _Ded.getclothingAllowance());
    System.out.println("Hourly Rate: " + _Ded.hourlyRate);
    System.out.println("Gross Semi-Monthly Rate: " + _Ded.getGrossSemiMonthly());
    System.out.println("Gross Weekly Salary: " + _Ded.grossWeeklySalary);
    System.out.println("Net Weekly Salary: " + _Ded.netWeeklySalary);
    System.out.println("Number of Hours Worked in a Week: " + _calc.computeEmployeeWorkHours(employeeNo));

    System.out.println(" ");
    System.out.println("DEDUCTIONS");
    System.out.println("SSS Contribution: " + _Ded.sssContribution);
    System.out.println("Philhealth Contribution: " + _Ded.philhealthContribution);
    System.out.println("Pag-ibig Contribution: " + _Ded.pagibigMaxContribution);
    System.out.println("Withholding Tax: " + _Ded.withholdingTax);
    System.out.println("******************************");
    }
  
}
