import java.util.Scanner;

public class BinaryToOctalConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binaryInput = scanner.nextLine();
        
        // Remove leading zeros
        binaryInput = binaryInput.replaceFirst("^0+", "");
        
        // Convert binary to octal
        String octalOutput = binaryToOctal(binaryInput);
        
        System.out.println("Octal equivalent: " + octalOutput);
        
        scanner.close();
    }
    
    public static String binaryToOctal(String binary) {
        // Ensure that the binary string length is a multiple of 3
        int length = binary.length();
        int remainder = length % 3;
        if (remainder != 0) {
            // Add leading zeros to make it a multiple of 3
            for (int i = 0; i < 3 - remainder; i++) {
                binary = "0" + binary;
            }
        }
        
        StringBuilder octal = new StringBuilder();
        int i = 0;
        while (i < binary.length()) {
            // Take groups of 3 bits and convert them to octal
            String groupOfThree = binary.substring(i, i + 3);
            int decimalValue = Integer.parseInt(groupOfThree, 2);
            octal.append(Integer.toOctalString(decimalValue));
            i += 3;
        }
        
        return octal.toString();
    }
}