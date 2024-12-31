import java.util.Scanner;

public class SimpleCalculator {
    public static void performOperation(int choice) {
        Scanner s = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.println("Enter the first number: ");
                int num1 = s.nextInt();
                System.out.println("Enter the second number: ");
                int num2 = s.nextInt();
                System.out.println("Addition of " + num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case 2:
                System.out.println("Enter the first number: ");
                num1 = s.nextInt();
                System.out.println("Enter the second number: ");
                num2 = s.nextInt();
                System.out.println("Subtraction of " + num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case 3:
                System.out.println("Enter the first number: ");
                num1 = s.nextInt();
                System.out.println("Enter the second number: ");
                num2 = s.nextInt();
                System.out.println("Multiplication of " + num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case 4:
                System.out.println("Enter the first number: ");
                num1 = s.nextInt();
                System.out.println("Enter the second number: ");
                num2 = s.nextInt();
                if (num2 != 0) {
                    System.out.println("Division of " + num1 + " / " + num2 + " = " + ((double) num1 / num2));
                } 
                else {
                    System.out.println("Error: Division by zero");
                }
                break;
            case 5:
                System.out.println("Enter the base number: ");
                double base = s.nextDouble();
                System.out.println("Enter the exponent: ");
                double exponent = s.nextDouble();
                System.out.println("Result of " + base + "^" + exponent + " = " + Math.pow(base, exponent));
                break;
            case 6:
                System.out.println("Enter the number: ");
                double num = s.nextDouble();
                if (num >= 0) {
                    System.out.println("Square root of " + num + " = " + Math.sqrt(num));
                } 
                else {
                    System.out.println("Error: Cannot calculate square root of a negative number");
                }
                break;

            case 7:
                System.out.println("1. Celsius to Fahrenheit\n2. Fahrenheit to Celsius");
                System.out.print("Enter your sub-choice: ");
                int tempChoice = s.nextInt();
                if (tempChoice == 1) {
                    System.out.println("Enter the temperature in Celsius: ");
                    double celsius = s.nextDouble();
                    System.out.println(celsius + " C = " + ((celsius * 9 / 5) + 32) + " F");
                } 
                else if (tempChoice == 2) {
                    System.out.println("Enter the temperature in Fahrenheit: ");
                    double fahrenheit = s.nextDouble();
                    System.out.println(fahrenheit + " F = " + ((fahrenheit - 32) * 5 / 9) + " C");
                } 
                else {
                    System.out.println("Invalid sub-choice");
                }
                break;
            
            case 8:
                System.out.println("1. USD to INR\n2. INR to USD");
                System.out.print("Enter your sub-choice: ");
                int currencyChoice = s.nextInt();
                if (currencyChoice == 1) {
                    System.out.println("Enter the amount in USD: ");
                    double usd = s.nextDouble();
                    System.out.println(usd + " USD = " + (usd * 82.5) + " INR");
                } 
                else if (currencyChoice == 2) {
                    System.out.println("Enter the amount in INR: ");
                    double inr = s.nextDouble();
                    System.out.println(inr + " INR = " + (inr / 82.5) + " USD");
                } 
                else {
                    System.out.println("Invalid sub-choice");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Exponentiation\n6. Square Root\n7. Temperature Conversion\n8. Currency Conversion\n");
        System.out.print("Enter the choice: ");

        int choice = s.nextInt();
        performOperation(choice);
    }
}
