
import java.util.Scanner;

public class InputReader {

    private final Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readRequiredText(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.out.println("Name cannot be empty.");
            } else if (!value.matches("[a-zA-Z ]+")) {
                System.out.println(
                        "Invalid name. Use letters and spaces only.");
            } else {
                return value;
            }
        }
    }

    public int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println(
                        "Enter a number between " + min + " and " + max + ".");

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }
}
