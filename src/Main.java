import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static double deposit = 0;
    private static double annualRate = 0;
    private static double factor = 0;

    public static void main(String[] args) {

        while (deposit == 0) {
            deposit = setNum("deposit");
        }
        while (annualRate == 0) {
            annualRate = setNum("annual rate");
        }
        while (factor == 0) {
            factor = setNum(deposit);
        }
        System.out.println("deposit: " + deposit + " annual rate: " + annualRate + " factor: " + factor);
        System.out.println("required sum: " + deposit * factor);
        List<Number> nums = calc(deposit, annualRate, factor);
        System.out.print("your sum: ");
        System.out.format("%,.2f%n", nums.get(1).doubleValue());
        System.out.println("years: " + nums.get(0));
    }

    private static double setNum(String type) {
        double num;
        Scanner scanner = new Scanner(System.in);
        System.out.print("input " + type + ": ");
        if (scanner.hasNextDouble() && (num = scanner.nextDouble()) > 0) {
            return num;
        } else {
            System.out.println("please insert positive numeric type");
            return 0;
        }
    }

    private static double setNum(double deposit) {
        double num = 0;
        while (num == 0) {
            num = setNum("factor");
            if ((num * deposit) > deposit) {
                return num;
            } else {
                System.out.println("factor should be more than 1");
                num = 0;
            }
        }
        return num;
    }

    private static List<Number> calc(double deposit, double annualRate, double factor) {
        List<Number> numbers = new ArrayList<>();
        int year = 0;
        double total = deposit * factor;
        while (deposit <= total) {
            deposit = deposit + (deposit * annualRate) / 100;
            year++;
        }
        numbers.add(year);
        numbers.add(deposit);
        return numbers;
    }
}
