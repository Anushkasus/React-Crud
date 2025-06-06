import java.util.Scanner;

public class OctalToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an octal number: ");
        String octalString = scanner.nextLine();

        try {
            // Convert octal string to decimal integer
            int decimalValue = Integer.parseInt(octalString, 8);

            System.out.println("Decimal equivalent: " + decimalValue);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid octal number.");
        } finally {
            scanner.close();
        }
    }
}
