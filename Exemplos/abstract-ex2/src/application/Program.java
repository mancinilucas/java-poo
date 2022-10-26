package application;

import entities.Individual;
import entities.Juridico;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayerList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();

            if(ch == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                taxPayerList.add(new Individual(name, anualIncome, healthExpenditures));
            }
            else{
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                taxPayerList.add(new Juridico(name, anualIncome, numberOfEmployees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");

        for(TaxPayer taxPayer : taxPayerList){
            System.out.printf("%s: $ %.2f%n", taxPayer.getName() ,taxPayer.tax());
        }

        double totalTaxes = 0.0;

        System.out.println();
        for(TaxPayer taxPayer : taxPayerList){
            totalTaxes += taxPayer.tax();
        }

        System.out.printf("TOTAL TAXES: $ %.2f" ,totalTaxes);

        sc.close();
    }
}
