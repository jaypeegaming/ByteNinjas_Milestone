
package com.mycompany.codealong;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Employee {
    private String _employeeNumber;
    private String _lastName;
    private String _firstName;
    private String _address;
    private String _birthday;
    private String _position;
    private String _ImmediateSupervisor;
    private String _status;
    private String _contactInfo;

    
    public String getBirthday(){
        return _birthday;    
    }
    public String getStatus(){
        return _status;    
    }
    public String getPosition(){
        return _position;    
    }
    public String getImmediateSupervisor(){
        return _ImmediateSupervisor;    
    }
    public String getEmployeenumber(){
        return _employeeNumber;    
    }
    public String getlastName(){
        return _lastName;
    }
    public String getFirstname(){
       return _firstName;
   }
    public String getAddress(){
       return _address;
   }
    public String getContactInfo(){
        return _contactInfo;    
    }
    
    public void setEmployeeNumber(String EmployeeNo){
       _employeeNumber = EmployeeNo;
   }
    public void setStatus(String Status){
       _status = Status;
   }
    public void setLastName(String LastName){
       _lastName = LastName;
   }
    public void setFirstName(String FirstName){
       _firstName = FirstName;
    }
    public void setAddress(String Address){
        _address = Address;
     }
    public void setBirthday(String Birthday){
        _birthday = Birthday;
     }
    public void setPosition(String Position){
        _position = Position;
     }  
    public void setImmediateSupervisor(String ImmediateSupervisor){
       _ImmediateSupervisor = ImmediateSupervisor;
    }
   public void setcontactInfo(String contactInfo){
       _contactInfo = contactInfo;
    }
    
   public Employee GetEmployee(String EmployeeNo) throws FileNotFoundException, IOException, CsvValidationException {
       String filename = "/Users/johnallenalcantara/Downloads/MotorPH Employee Data - Employee Details.csv";
       CSVReader reader = new CSVReader(new FileReader(filename));
       String[] header = reader.readNext();
       String[] employee;
       while ((employee = reader.readNext())!= null){
           if (employee[0].equals(EmployeeNo)){
                this._employeeNumber = employee[0];
                this._lastName = employee[1];
                this._firstName = employee[2];
                this._address = employee[4];
                this._contactInfo = employee [5];
                this._birthday = employee[3];
                this._position = employee[11];
                this._ImmediateSupervisor = employee[12];
                this._status = employee [10];
                
           }
       }
       return this;
   } 
}
