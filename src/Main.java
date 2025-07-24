import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            manager.menu();
            int command = scanner.nextInt();
            manager.commands(command);
        }
    }
}