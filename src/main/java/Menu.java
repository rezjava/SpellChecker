import java.io.IOException;

public class Menu {

    public void showMenu() {
        System.out.println("|===========================|");
        System.out.println("|     MENU SELECTION        |");
        System.out.println("|===========================|");
        System.out.println("|     Options:              |");
        System.out.println("|  1. reading of the list   |");
        System.out.println("|  2. spelling of the words |");
        System.out.println("| 'q' exit from program     |");
        System.out.println("|===========================|");
        System.out.println("*****************************");
    }
    public char takeChoise() throws IOException {
        char choice, ignore;
        System.out.print("input your choice: ");
        choice = (char) System.in.read();
        do {
            ignore = (char) System.in.read();
        } while (ignore != '\n');

        switch (choice) {
            case '1':
                System.out.println("reading of the list all words");
                break;
            case '2':
                System.out.println("spelling of the words");
                break;
            case 'q':
                System.out.println("goodbye!");
                choice = 'q';
                break;
        }
        return choice;
    }
}
