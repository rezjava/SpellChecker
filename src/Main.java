import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    private static final String MAINFILE = "/home/ubuntu/IdeaProjects/ActiveVocabulary/maintext";
    private static final String FILE1 = "/home/ubuntu/IdeaProjects/ActiveVocabulary/list1";
    private static final String FILE2 = "/home/IdeaProjects/ActiveVocabulary/list2";
    private static final String FILE3 = "/home/IdeaProjects/ActiveVocabulary/list3";

    private static void showMenu() {
        System.out.println("|===========================|");
        System.out.println("|     MENU SELECTION        |");
        System.out.println("|===========================|");
        System.out.println("|     Options:              |");
        System.out.println("|  1. start learning        |");
        System.out.println("|  2. input new words       |");
        System.out.println("|  3. show all words        |");
        System.out.println("| 'q' exit from program     |");
        System.out.println("|===========================|");
        System.out.println("*****************************");
    }

    private static boolean isChoiceValid(int ch) {
        if (ch < '1' | ch > '4' & ch != 'q') return false;
        return true;
    }


    public static void main(String[] args) throws IOException {

        char choice, ignore;
        label:

        for (; ; ) {
            Word obj = new Word();

            obj.readMainFile(MAINFILE,FILE1);

            obj.readFile1(FILE1);
            do {
                showMenu();
                System.out.print("input your choice: ");
                choice = (char) System.in.read();
                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');

                LinkedList list = null;

                switch (choice) {
                    case '1':
                        System.out.println("start learning words");
                        break;
                    case '2':
                        int key;
                        do {
                            System.out.println("for queit press 'esc'");
                            key = System.in.read();
                        } while (key != 27);
                        break;
                    case '3':
                        System.out.println("show all words");
                        obj.readFile1(FILE1);
                        break;
                    case 'q':
                        System.out.println("quiet");
                        break label;
                }
            } while (!isChoiceValid(choice));
        }
    }
}


