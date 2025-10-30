import java.util.*;

class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + age + " | " + salary;
    }
}

public class SortEmployeesUsingLambda {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Amit", 25, 45000));
        employees.add(new Employee(102, "Sambhav", 28, 55000));
        employees.add(new Employee(103, "Riya", 23, 40000));
        employees.add(new Employee(104, "Manish", 30, 60000));

        System.out.println("=== Sort by Name ===");
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        employees.forEach(System.out::println);

        System.out.println("\n=== Sort by Age ===");
        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        employees.forEach(System.out::println);

        System.out.println("\n=== Sort by Salary (Descending) ===");
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        employees.forEach(System.out::println);
    }
}
