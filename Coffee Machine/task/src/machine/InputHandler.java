package machine;

import java.util.Scanner;

public class InputHandler {
    Scanner scanner = new Scanner(System.in);

    public String getStrInput() {
        String input = scanner.nextLine();
        return input;
    }

    public int getIntInput() {
        int input = scanner.nextInt();
        return input;
    }
}
