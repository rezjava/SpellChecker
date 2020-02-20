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
        System.out.println("|  1. reading of the list   |");
        System.out.println("|  2. spelling of the words |");
        System.out.println("| 'q' exit from program     |");
        System.out.println("|===========================|");
        System.out.println("*****************************");
    }

    private static boolean isChoiceValid(int ch) {
        if (ch < '1' | ch > '3' & ch != 'q') return false;
        return true;
    }


    public static void main(String[] args) throws IOException, NoSuchFieldException {

        char choice, ignore;
        label:
        {
            Word obj = new Word();
            ReadingOfList readingOfList = new ReadingOfList();
            Spelling spelling = new Spelling();

            obj.readMainFile(MAINFILE, FILE1);
            readingOfList.readFile1(FILE1);
            do {
                showMenu();
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
                        System.out.println("quiet");
                        break label;
                }
            } while (!isChoiceValid(choice));
        }
    }
}


