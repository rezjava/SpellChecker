import java.io.File;
import java.io.IOException;

public class Program {
    private static final String MAIN_FILE = "/home/ubuntu/IdeaProjects/ActiveVocabulary/mainfile.txt.txt";
    private static final String WORK_FILE = "/home/ubuntu/IdeaProjects/ActiveVocabulary/workfile.txt";

    public static void main(String[] args) throws IOException, NoSuchFieldException {

        if (isFileExists(args[0]))
            System.out.println("You have to input ");
        Program mainObject = new Program();
        mainObject.run();
    }

    private boolean isChoiceValid(int ch) {
        if (ch < '1' | ch > '3' & ch != 'q') return false;
        return true;
    }

    private static boolean isFileExists(String filename) {
        File chack;
        try {
            chack = File.createTempFile("/home/ubuntu/IdeaProjects/ActiveVocabulary/mainfile.txt", ".txt");

            boolean exists = chack.exists();
            if (exists) return true;
            else {
                System.out.println("Vocabulary file doesn't exists");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void run() throws IOException {


        Word obj = new Word();
        ReadingOfFile readingOfList = new ReadingOfFile();
        Spelling spelling = new Spelling();
        Menu menu = new Menu();
        ReadingOfFile reading = new ReadingOfFile();
        reading.readMainFile(MAIN_FILE, WORK_FILE);
        reading.readFile1(WORK_FILE);
        char choice;
        do {
            menu.showMenu();
            choice = menu.takeChoise();
        } while (!isChoiceValid(choice));
    }
}


