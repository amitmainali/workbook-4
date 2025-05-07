package com.pluralsight;

import java.time.LocalTime;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double startTime;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.startTime = -1;
    }

    public void punchIn(double time) {
        if (startTime == -1) {
            startTime = time;
        }
    }

    public void punchIn() {
        LocalTime now = LocalTime.now();

        if (startTime == -1) {
            startTime = now.getHour() + (now.getMinute() / 60.0) + (now.getSecond() / 3600.0);
        }
    }

    public void punchOut(double time) {
        if (startTime != -1) {
            double worked = time - startTime;
            hoursWorked = hoursWorked + worked;
            startTime = -1;
        }
    }

    public void punchOut() {
        LocalTime now = LocalTime.now();

        if (startTime != -1) {
            double endTime = now.getHour() + (now.getMinute() / 60.0) + (now.getSecond() / 3600.0);
            double worked = endTime - startTime;
            hoursWorked = hoursWorked + worked;
            startTime = -1;
        }
    }
    public double getRegularHours() {
        if (hoursWorked <= 40) {
            return hoursWorked;
        } else {
            return 40;
        }
    }

    public double getOvertimeHours() {
        if (hoursWorked > 40) {
            return hoursWorked - 40;
        } else {
            return 0;
        }
    }

    public double getTotalPay() {
        double regularPay = getRegularHours() * payRate;
        double overtimePay = getOvertimeHours() * payRate * 1.5;
        return regularPay + overtimePay;
    }
}