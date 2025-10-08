import java.util.InputMismatchException;
import java.util.Scanner;

// Non-public Calculator class (OK to keep in same file as public CalculatorApplication)
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public double multiply(double a, double b) {
        return a * b;
    }
    public double divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Error: Cannot divide by zero.");
        }
        return (double) a / b;
    }
}

public class CalculatorApplication {
    private static final Scanner sc = new Scanner(System.in);
    private static final Calculator calc = new Calculator();

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input! Please enter an integer.");
                sc.next(); // Clear invalid input
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextDouble();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input! Please enter a decimal number.");
                sc.next(); // Clear invalid input
            }
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nWelcome to the Calculator Application!");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    System.out.println("Select type of addition:");
                    System.out.println("1. Add two integers");
                    System.out.println("2. Add two doubles");
                    System.out.println("3. Add three integers");
                    int addChoice = readInt("Enter your addition type: ");
                    switch (addChoice) {
                        case 1:
                            int a1 = readInt("Enter first integer: ");
                            int b1 = readInt("Enter second integer: ");
                            System.out.println("Result: " + calc.add(a1, b1));
                            break;
                        case 2:
                            double a2 = readDouble("Enter first double: ");
                            double b2 = readDouble("Enter second double: ");
                            System.out.println("Result: " + calc.add(a2, b2));
                            break;
                        case 3:
                            int a3 = readInt("Enter first integer: ");
                            int b3 = readInt("Enter second integer: ");
                            int c3 = readInt("Enter third integer: ");
                            System.out.println("Result: " + calc.add(a3, b3, c3));
                            break;
                        default:
                            System.out.println("Invalid choice!");
                    }
                    break;

                case 2:
                    int sub1 = readInt("Enter first integer: ");
                    int sub2 = readInt("Enter second integer: ");
                    System.out.println("Result: " + calc.subtract(sub1, sub2));
                    break;

                case 3:
                    double mul1 = readDouble("Enter first double: ");
                    double mul2 = readDouble("Enter second double: ");
                    System.out.println("Result: " + calc.multiply(mul1, mul2));
                    break;

                case 4:
                    int num = readInt("Enter numerator (int): ");
                    int denominator = readInt("Enter denominator (int): ");
                    try {
                        System.out.println("Result: " + calc.divide(num, denominator));
                    } catch (ArithmeticException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the Calculator. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        } while (choice != 5);

        sc.close();
    }
}
