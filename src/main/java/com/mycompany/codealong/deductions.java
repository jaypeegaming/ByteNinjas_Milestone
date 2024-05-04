
package com.mycompany.codealong;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class deductions {
    
    private double hoursWorked;
    private double _basicSalary;
    private double _riceSubsidy;
    private double _phoneAllowance;
    private double _clothingAllowance;
    public double sssContribution;
    public double withholdingTax;
    public double GrossSemiMonthly;
    public double philhealthContribution;
    double pagibigMaxContribution = 100;
    
    public double getBasicsalary(){
        return _basicSalary;
    }
    public double getriceSubsidy(){
        return _riceSubsidy;
    }
    public double getphoneAllowance(){
        return _phoneAllowance;
    }
    public double getclothingAllowance(){
        return _clothingAllowance;
    }
    public double getGrossSemiMonthly(){
        return GrossSemiMonthly;
    }
    // Calculate Hourly Rate
      double hourlyRate = (_basicSalary / 21)/8;
                    
    // Calculate Gross Weekly Salary
      double grossWeeklySalary = hourlyRate * hoursWorked;
       
         
        // Calculate Net Weekly Salary
     double Deductions = sssContribution + philhealthContribution + pagibigMaxContribution + withholdingTax;
        
     double netWeeklySalary = grossWeeklySalary - (Deductions/ 4);
     
  public deductions GetDeductions(String EmployeeNo) throws FileNotFoundException, IOException, CsvValidationException {
       String filename = "MotorPH Employee Data - Employee Details.csv";
       CSVReader reader = new CSVReader(new FileReader(filename));
       String[] header = reader.readNext();
       String[] employee;
      while ((employee = reader.readNext())!= null){
           if (employee[0].equals(EmployeeNo)){
                this._basicSalary = Double.parseDouble(employee[13].replace(",", ""));
                this._riceSubsidy = Double.parseDouble(employee[14].replace(",", ""));
                this._phoneAllowance = Double.parseDouble (employee[15].replace(",", ""));
                this._clothingAllowance = Double.parseDouble(employee[16].replace(",", ""));
                this.GrossSemiMonthly=Double.parseDouble(employee[17].replace(",", ""));
                this.hourlyRate=Double.parseDouble(employee[18].replace(",", ""));
           }
         
// Calculate SSS Contribution
      
        if (_basicSalary <= 3250) {
            sssContribution = 135;
        } else if (_basicSalary <= 3750) {
            sssContribution = 157.50;
        } else if (_basicSalary <= 4250) {
            sssContribution = 180;
        } else if (_basicSalary <= 4750) {
            sssContribution = 202.50;
        } else if (_basicSalary <= 5250) {
            sssContribution = 225;
        } else if (_basicSalary <= 5750) {
            sssContribution = 247.50;
        } else if (_basicSalary <= 6250) {
            sssContribution = 270;
        } else if (_basicSalary <= 6750) {
            sssContribution = 292.50;
        } else if (_basicSalary <= 7250) {
            sssContribution = 315;
        } else if (_basicSalary <= 7750) {
            sssContribution = 337.50;
        } else if (_basicSalary <= 8250) {
            sssContribution = 360;
        } else if (_basicSalary <= 8750) {
            sssContribution = 382.50;
        } else if (_basicSalary <= 9250) {
            sssContribution = 405;
        } else if (_basicSalary <= 9750) {
            sssContribution = 427.50;
        } else if (_basicSalary <= 10250) {
            sssContribution = 450;
        } else if (_basicSalary <= 10750) {
            sssContribution = 472.50;
        } else if (_basicSalary <= 11250) {
            sssContribution = 495;
        } else if (_basicSalary <= 11750) {
            sssContribution = 517.50;
        } else if (_basicSalary <= 12250) {
            sssContribution = 540;
        } else if (_basicSalary <= 12750) {
            sssContribution = 562.50;
        } else if (_basicSalary <= 13250) {
            sssContribution = 585;
        } else if (_basicSalary <= 13750) {
            sssContribution = 607.50;
        } else if (_basicSalary <= 14250) {
            sssContribution = 630;
        } else if (_basicSalary <= 14750) {
            sssContribution = 652.50;
        } else if (_basicSalary <= 15250) {
            sssContribution = 675;
        } else if (_basicSalary <= 15750) {
            sssContribution = 697.50;
        } else if (_basicSalary <= 16250) {
            sssContribution = 720.00;
        } else if (_basicSalary <= 16750) {
            sssContribution = 742.50;
        } else if (_basicSalary <= 17250) {
            sssContribution = 765.00;
        } else if (_basicSalary <= 17750) {
            sssContribution = 787.50;
        } else if (_basicSalary <= 18250) {
            sssContribution = 810.00;
        } else if (_basicSalary <= 18750) {
            sssContribution = 832.50;
        } else if (_basicSalary <= 19250) {
            sssContribution = 855.00;
        } else if (_basicSalary <= 19750) {
            sssContribution = 877.50;
        } else if (_basicSalary <= 20250) {
            sssContribution = 900.00;
        } else if (_basicSalary <= 20750) {
            sssContribution = 922.50;
        } else if (_basicSalary <= 21250) {
            sssContribution = 945.00;
        } else if (_basicSalary <= 21750) {
            sssContribution = 967.50;
        } else if (_basicSalary <= 22250) {
            sssContribution = 990.00;
        } else if (_basicSalary <= 22750) {
            sssContribution = 1012.50;
        } else if (_basicSalary <= 23250) {
            sssContribution = 1035.00;
        } else if (_basicSalary <= 23750) {
            sssContribution = 1057.50;
        } else if (_basicSalary <= 24250) {
            sssContribution = 1080.00;
        } else if (_basicSalary <= 24750) {
            sssContribution = 1102.50;
        } else {
            sssContribution = 1125.00;
        }
        
        // Calculate Philhealth Contribution
        
        if (_basicSalary <= 10000) {
            philhealthContribution = _basicSalary * 0.03 * 0.5;
        } else if (_basicSalary <= 59999.99) {
            philhealthContribution = _basicSalary * 0.03 * 0.5;
        } else {
            philhealthContribution = 1800 * 0.5;
        }
        
        // Calculate Pag-ibig Contribution
   
    double pagibigEmployeeContributionRate = 0;
    double pagibigEmployerContributionRate = 0;
    double pagibigTotalContributionRate = 0;
    double pagibigEmployeeContribution = 0;
    double pagibigEmployerContribution = 0;
    double pagibigTotalContribution = 0;
   
    
        if (_basicSalary >= 1000 && _basicSalary <= 1500) {
            pagibigEmployeeContributionRate = 0.01;
            pagibigEmployerContributionRate = 0.02;
            pagibigTotalContributionRate = 0.03;
        } else if (_basicSalary > 1500) {
            pagibigEmployeeContributionRate = 0.02;
            pagibigEmployerContributionRate = 0.02;
            pagibigTotalContributionRate = 0.04;
        }

        pagibigEmployeeContribution = _basicSalary * pagibigEmployeeContributionRate;
        pagibigEmployerContribution = _basicSalary * pagibigEmployerContributionRate;
        pagibigTotalContribution = pagibigEmployeeContribution + pagibigEmployerContribution;

        if (pagibigTotalContribution > pagibigMaxContribution) {
            pagibigTotalContribution = pagibigMaxContribution;
        }
        
        // Calculate Withholding tax
        if (_basicSalary <= 20832) {
            withholdingTax = 0;
        } else if (_basicSalary <= 33332) {
            withholdingTax = (grossWeeklySalary - 20832) * 0.20;
        } else if (_basicSalary <= 66667) {
            withholdingTax = 2500 + (grossWeeklySalary - 33332) * 0.25;
        } else if (_basicSalary <= 166667) {
            withholdingTax = 10833 + (grossWeeklySalary - 66667) * 0.30;
        } else if (_basicSalary <= 666667) {
            withholdingTax = 40833.33 + (grossWeeklySalary - 166667) * 0.32;
        } else {
            withholdingTax = 200833.33 + (grossWeeklySalary - 666667) * 0.35;
        }
     
    }
        return this;
       
 }
}
