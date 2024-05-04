
package com.mycompany.codealong;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkHoursCalc{
    private static final String CSV_FILE_PATH = "MotorPH Employee Data - Attendance Record.csv";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm");
    private static final long GRACE_PERIOD = 10 * 60 * 1000; // 10 minutes in milliseconds
    private static final long WORK_DAY_START = 8 * 60 * 60 * 1000; // 8:00 AM in milliseconds
    private static final long WORK_DAY_END = 17 * 60 * 60 * 1000; // 5:00 PM in milliseconds

    public Map<String, Long> computeEmployeeWorkHours(String filePath) throws CsvValidationException, CsvException {
        Map<String, Long> employeeWorkHours = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext();
            List<String[]> employeeData = reader.readAll();
            
            for (String[] employee : employeeData) {
                String employeeNumber = employee[0];
                String loginTimeStr = employee[4];
                String logoutTimeStr = employee[5];
                long workHours = 0;

                try {
                    Date loginTime = DATE_FORMAT.parse(loginTimeStr);
                    Date logoutTime = DATE_FORMAT.parse(logoutTimeStr);

                    workHours = calculateWorkHours(loginTime, logoutTime);
                    if (employeeWorkHours.containsKey(employeeNumber)) {
                        long totalWorkHours = employeeWorkHours.get(employeeNumber);
                        totalWorkHours += workHours;
                        employeeWorkHours.put(employeeNumber, totalWorkHours);
                    } else {
                        employeeWorkHours.put(employeeNumber, workHours);
                    }
                } catch (ParseException e) {
                    System.out.println("Error parsing date: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }

        return employeeWorkHours;
    }

    private static long calculateWorkHours(Date loginTime, Date logoutTime) {
        long totalWorkTime = 0;

        totalWorkTime += logoutTime.getTime() - loginTime.getTime();

        return totalWorkTime / (60 * 60 * 1000); // Convert milliseconds to hours
    }
}
