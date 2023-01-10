package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter path: ");
        String path = sc.nextLine();
        System.out.println("Enter salary: ");
        Double salary = sc.nextDouble();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Employee> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null){
                String[]fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }
            Comparator<String>comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
            List<String> avgSalary = list.stream()
                    .filter(e -> e.getSalary() > salary)
                    .map(e -> e.getEmail())
                    .sorted(comp)
                    .collect(Collectors.toList());

            System.out.printf("Email of people whose salary is more than %.2f: %n", salary);
            avgSalary.forEach(System.out::println);

            double sumOfSalary = list.stream()
                    .filter(e -> e.getName().charAt(0) == 'M')
                    .map(e -> e.getSalary())
                    .reduce(0.0, (x,y) -> x + y);

            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sumOfSalary));

        }catch (IOException e){
            System.out.println("Error: " + e);
        }
        sc.close();
    }
}
