import java.util.Scanner;

public class Calculator {
    public static String getMethod(String equation) {
        String[] methods = {"+", "-", "*", "/", "^", "%"};
        for (String method : methods) {
            if (equation.contains(method)) {
                return method;
            }
        }
        return "Error";
    }

    public static double[] getNumbers(String equation) {
        String method = getMethod(equation);
        String[] stringNumbers = equation.split(method, 2);
        double[] numbers = {Double.parseDouble(stringNumbers[0].strip()), Double.parseDouble(stringNumbers[1].strip())};
        return numbers;
    }

    public static void calculate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an expression with +, -, *, /, ^, or %: ");
        String equation = input.nextLine();
        String method = getMethod(equation);
        double[] numbers = getNumbers(equation);
        input.close();

        double result;

        if (method.equals("+")) {
            result = add(numbers[0], numbers[1]);
        } else if (method.equals("-")) {
            result = subtract(numbers[0], numbers[1]);
        } else if (method.equals("*")) {
            result = multiply(numbers[0], numbers[1]);
        } else if (method.equals("/")) {
            result = divide(numbers[0], numbers[1]);
        } else if (method.equals("^")) {
            result = pow(numbers[0], numbers[1]);
        } else { // method equals "%"
            result = mod(numbers[0], numbers[1]);
        }

        System.out.println(equation + " = " + result);
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        return num1 / num2;
    }

    public static double pow(double num1, double num2) {
        return Math.pow(num1, num2);
    }

    public static double mod(double num1, double num2) {
        return num1 % num2;
    }
}
