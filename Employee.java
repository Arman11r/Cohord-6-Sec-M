import java.util.*;

class Employee {
    String name;
    int id;
    String department;
    double basicSalary;

    public Employee(String name, int id, String department, double basicSalary) throws IllegalArgumentException {
        if (basicSalary < 0) throw new IllegalArgumentException("Salary cannot be negative");
        this.name = name;
        this.id = id;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    double calculateGrossSalary() {
        double allowance = 0.3 * basicSalary;  // 30% allowance
        return basicSalary + allowance;
    }

    double calculateTax() {
        double gross = calculateGrossSalary();
        if (gross <= 30000) return gross * 0.1;
        else if (gross <= 60000) return gross * 0.2;
        else return gross * 0.3;
    }

    double calculateNetAnnualSalary() {
        double monthlyNet = calculateGrossSalary() - calculateTax();
        return monthlyNet * 12;
    }

    void displaySalaryDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department);
        System.out.printf("Gross Salary: %.2f, Tax: %.2f, Annual Net Salary: %.2f\n",
                          calculateGrossSalary(), calculateTax(), calculateNetAnnualSalary());
        System.out.println("---------------------------------------------------");
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            try {
                System.out.println("\nEnter details for employee " + (i + 1) + ":");

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("ID: ");
                int id = Integer.parseInt(scanner.nextLine());

                System.out.print("Department: ");
                String dept = scanner.nextLine();

                System.out.print("Basic Salary: ");
                double basic = Double.parseDouble(scanner.nextLine());

                Employee emp = new Employee(name, id, dept, basic);
                employees.add(emp);

            } catch (NumberFormatException e) {
                System.out.println("Invalid number input. Please try again.");
                i--;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                i--;
            }
        }

        System.out.println("\n========= Annual Salary Report =========");
        for (Employee emp : employees) {
            emp.displaySalaryDetails();
        }

        scanner.close();
    }
}
