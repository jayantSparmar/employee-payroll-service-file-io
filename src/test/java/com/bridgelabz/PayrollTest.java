package com.bridgelabz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@SuppressWarnings("deprecation")
public class PayrollTest {

    @Test
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeesEntries() {
        EmployeePayrollData[] arrayOfEmps = { new EmployeePayrollData(1, 25000.56, "Jayant Singh Parmar"),
                new EmployeePayrollData(2, 15000.65, "Ashvini kanojiya"),
                new EmployeePayrollData(3, 22000.67, "Shubham Pawar") };
        EmployeePayrollService EmployeePayrollService;
        EmployeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        EmployeePayrollService.write(com.bridgelabz.EmployeePayrollService.IOService.FILE_IO);
        long entriesCount=EmployeePayrollService.countEntries(com.bridgelabz.EmployeePayrollService.IOService.FILE_IO);
        EmployeePayrollService.printData(com.bridgelabz.EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(3, entriesCount);
    }

    @Test
    public void givenFileOnReadingFromFileShouldMatchEmployeeCount() {
        EmployeePayrollService payrollService=new EmployeePayrollService();
        long entries=payrollService.readEmployeeData(EmployeePayrollService.IOService.FILE_IO);
    }

}
