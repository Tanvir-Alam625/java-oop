package calculator;

import java.io.IOException;
import java.util.Scanner;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

public class CalculatorConsoleService {

    public void run() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            Calculator calculator = new Calculator();

            System.out.println("Enter first number: ");
            int first = Integer.parseInt(scanner.nextLine().trim());

            System.out.println("Enter second number: ");
            int second = Integer.parseInt(scanner.nextLine().trim());

            int choice;
            try {
                choice = selectOperationWithArrows();
            } catch (NoClassDefFoundError error) {
                choice = selectOperationWithNumberInput(scanner);
            }

            switch (choice) {
                case 1:
                    System.out.println("Result: " + calculator.add(first, second));
                    break;
                case 2:
                    System.out.println("Result: " + calculator.subtract(first, second));
                    break;
                case 3:
                    System.out.println("Result: " + calculator.multiply(first, second));
                    break;
                case 4:
                    System.out.println("Result: " + calculator.divide(first, second));
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private int selectOperationWithArrows() throws IOException {
        String[] options = {"Add", "Subtract", "Multiply", "Divide"};
        int selected = 0;

        try (Terminal terminal = TerminalBuilder.builder().system(true).build()) {
            terminal.enterRawMode();
            NonBlockingReader reader = terminal.reader();

            while (true) {
                renderMenuSingleLine(terminal, options, selected);

                int ch = reader.read();
                if (ch == 27) {
                    int c2 = reader.read();
                    int c3 = reader.read();
                    if (c2 == 91 && c3 == 68) {
                        selected = (selected - 1 + options.length) % options.length;
                    }
                    if (c2 == 91 && c3 == 67) {
                        selected = (selected + 1) % options.length;
                    }
                } else if (ch == 10 || ch == 13) {
                    terminal.writer().println();
                    terminal.flush();
                    return selected + 1;
                }
            }
        }
    }

    private void renderMenuSingleLine(Terminal terminal, String[] options, int selected) {
        StringBuilder line = new StringBuilder("\r\033[2KUse ←/→ and Enter: ");
        for (int i = 0; i < options.length; i++) {
            if (i == selected) {
                line.append("\u001B[7m>").append(options[i]).append("<\u001B[0m");
            } else {
                line.append(options[i]);
            }
            if (i < options.length - 1) {
                line.append(" | ");
            }
        }
        terminal.writer().print(line);
        terminal.flush();
    }

    private int selectOperationWithNumberInput(Scanner scanner) {
        while (true) {
            System.out.println("Choose operation: 1) Add 2) Subtract 3) Multiply 4) Divide");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid choice. Enter 1, 2, 3, or 4.");
        }
    }
}
