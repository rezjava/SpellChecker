import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    private static final String MAINFILE = "/home/ubuntu/IdeaProjects/ActiveVocabulary/maintext";
    private static final String FILE1 = "/home/ubuntu/IdeaProjects/ActiveVocabulary/list1";
    private static final String FILE2 = "/home/IdeaProjects/ActiveVocabulary/list2";
    private static final String FILE3 = "/home/IdeaProjects/ActiveVocabulary/list3";

    private static boolean isChoiceValid(int ch) {
        if (ch < '1' | ch > '3' & ch != 'q') return false;
        return true;
    }

    public static void main(String[] args) throws IOException, NoSuchFieldException {
        label:
        {
            Word obj = new Word();
            ReadingOfList readingOfList = new ReadingOfList();
            Spelling spelling = new Spelling();
            Menu menu = new Menu();
            obj.readMainFile(MAINFILE, FILE1);
            readingOfList.readFile1(FILE1);
            char choice;
            do {
                menu.showMenu();
                choice = menu.takeChoise();
                if (choice == 'q')
                    break label;
            } while (!isChoiceValid(choice));
        }
    }
}


