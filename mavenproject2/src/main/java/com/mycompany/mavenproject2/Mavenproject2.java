/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

/**
 *
 * @author admin
 */
import java.util.Scanner;
public class Mavenproject2 {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       char repeat;
       
        do {            
            System.out.println("Enter of the numbers employees ");
            int n = sc.nextInt();
            sc.nextLine();
            
            String[] name = new String [n];
            String[] type = new String [n];
            double[] gross = new double [n];
            double[] netGross = new double[n];
            double[] deduction = new double [n];
            double[] salary = new double[n];
            double[] tax = new double[n];
            double[] sss = new double[n];
            double[] net = new double[n];
            double[] philHealth = new double[n];
            double[] pagIbig = new double[n];
            
            for(int i = 0; i < n; i++) {
                System.out.println("\n---Employee #" + (i + 1 ) + "-----");
                System.out.println("Enter your name ");
                name[i] = sc.nextLine();
                
                System.out.println("Enter Type (Full-Time / Part time): ");
                 type[i] = sc.nextLine();
                 
                 double grossPay = 0;
                 //full time or part time 
                if (type[i].equalsIgnoreCase("Full-Time")){ //Full time
                    System.out.println("Enter Basic Salary");
                    double basic = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter Allowance: ");
                    double allowance = sc.nextDouble();
                    grossPay = basic + allowance;
                 }
                
               else if (type[i].equalsIgnoreCase("Part-Time")) { //Part 
                    System.out.println("Enter Rate per Hour: ");
                    double rate = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter Hours Worked: ");
                    double hours = sc.nextDouble();
                    sc.nextLine();
                   grossPay = rate + hours;
               }  
               
               else {
                    System.out.println("Invalid type. skipping...");
                    i++;
                    sc.nextLine();
                    continue;
               }
                //deducation
                System.out.println("Enter Days Absent: ");
                int absent = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Minute Late: ");
                int late = sc.nextInt();
                
                double absenceDeducation = (absent * 500) + ((late / 60.0 ) * 100); 
                
                //tax
                double taxAmount = 0;
                if (grossPay <= 10000 ){ 
                    taxAmount = grossPay * 0.05;
                }
                else if (grossPay <= 20000){
                    taxAmount = grossPay * 0.10;
                } else {
                    taxAmount = grossPay * 0.15; 
                }
                  double sssA = grossPay  * 0.045;
                  double philHealthA = grossPay * 0.075;
                  double pagIbigA = 100;
                  
                  double totalDeductions = absenceDeducation + taxAmount + sssA + philHealthA + pagIbigA;
                    
                  double netPay = grossPay - totalDeductions;
                  gross[i] = grossPay;
                  deduction[i] = absenceDeducation;
                  tax[i] = taxAmount;
                  sss[i] = sssA;
                  pagIbig[i] = philHealthA;
                  philHealth[i] = philHealthA;
                  net[i] = philHealthA;                          
            }
            
            System.out.println("\n----------------------------------------------------------------");
            System.out.println("Name\t\tType\t\tGross\t\tDeductions\t\tTax\t\tSSS\tPhilhealth\t\tPag-IBIG\t\tNet");
            System.out.println("----------------------------------------------------------------");
            
            for (int i = 0; i < n; i++) {
               System.out.printf("%-10s\t%-10s\t%.2f\t%.2f\t\t%.2f\t%.2f\t%.2f\t\t%.2f\t\t%.2f\n",
                 name[i], type[i], gross[i], deduction[i], tax[i], sss[i], philHealth[i], pagIbig[i], net[i]);
            }
            
             System.out.println("----------------------------------------------------------------");
             System.out.println("Payroll System computation complete!");
             
             System.out.println("\nDo you want to prcocess another payroll? (Y/N)");
             repeat = sc.next().charAt(0);
             sc.nextLine();
             
                    
        } while (repeat == 'Y' || repeat == 'y');
           System.out.println("\n Thank you for using the Payroll System!");
           sc.close();
        } 
    
    }

