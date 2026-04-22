import java.util.Scanner;

public class Calculator
{
    public static class jv {
        double num1, num2;
        int choice;

        public double addNums(double n1, double n2) {
            return n1 + n2;
        }
        public double subtractNums(double n1, double n2) {
            return n1 - n2;
        }
        public double multiplyNums(double n1, double n2) {
            return n1 * n2;
        }
        public double divideNums(double n1, double n2) {
            return n1 / n2;
        }
        public double modulus(double n1, double n2) {
            return n1 % n2;
        }
    }

    public static void main(String[] args) {
        jv c = new jv();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the choice of arithmetic operation: 1.addition 2.subtraction 3.multiplication 4.division 5.modulus");
        c.choice = scan.nextInt();

        System.out.println("enter first number");
        c.num1 = scan.nextDouble();

        System.out.println("enter second number");
        c.num2 = scan.nextDouble();

        switch (c.choice) {
            case 1:
                System.out.println("Result: " + c.addNums(c.num1, c.num2));
                break;
            case 2:
                System.out.println("Result: " + c.subtractNums(c.num1, c.num2));
                break;
            case 3:
                System.out.println("Result: " + c.multiplyNums(c.num1, c.num2));
                break;
            case 4:
                System.out.println("Result: " + c.divideNums(c.num1, c.num2));
                break;
            case 5:
                System.out.println("Result: " + c.modulus(c.num1, c.num2));
                break;
            default:
                System.out.println("Invalid choice");
        }
        scan.close();
    }
}
