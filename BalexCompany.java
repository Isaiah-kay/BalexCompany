/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kvm.balexcompany;


import java.util.Scanner;

public class BalexCompany {

    public void calculatePay(String employeeName, double basePay, int hoursWorked) {
        System.out.println("Payment calculation for " + employeeName);
        System.out.println("Base Pay is $" + basePay);
        System.out.println("Hours Worked: " + hoursWorked);

        //if function for the erros to generate
        if (basePay < 8) {
            System.out.println("Base pay must be at least $8 per hour.");
            return;
        }
        if (hoursWorked > 60) {
            System.out.println("Hours worked cannot exceed 60 hours.");
            return;
        }

        //Calculating overtime payment - (hours-40)
        double totalPay;
        if (hoursWorked > 40) {
            int overtimeHours = hoursWorked - 40;
            //overtime = (hours-40)*((basepay)*1.5))
            totalPay = (40 * basePay) + (overtimeHours * basePay * 1.5);
        } else {
            totalPay = hoursWorked * basePay;
        }

        System.out.println("The Total pay for " + employeeName + " is: $" + totalPay);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BalexCompany company = new BalexCompany();

        System.out.println("Enter number of employees:");
        int numberOfEmployees = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        //a for loop to run for the employees to be entered
        for (int i = 1; i <= numberOfEmployees; i++) {
            System.out.println("Enter the name of employee " + i + ":");
            String employeeName = sc.nextLine();

            System.out.println("Enter base pay for " + employeeName + ":");
            double basePay = sc.nextDouble();

            System.out.println("Enter hours worked for " + employeeName + ":");
            int hoursWorked = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            company.calculatePay(employeeName, basePay, hoursWorked);
        }

        //closing the scanner
        sc.close();
    }
}
