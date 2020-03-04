import java.io.File;
import java.io.IOException;

public class Program {
    private static final String WORK_FILE = "/home/workfile.txt";

    public static void main(String[] args) throws IOException, NoSuchFieldException {
        final String mainFile = args[0];
        Program mainObject = new Program();
        if (isFileExists(args[0])) {
            if (isFileExists(WORK_FILE)) {
                mainObject.run(mainFile);
            } else {
                File file = new File("/home/workfile.txt");
                mainObject.run(mainFile);
            }
        } else
            System.out.println("You have to create your Vocabulary file and input it as parameter of program");
    }

    private boolean isChoiceValid(int ch) {
        if (ch < '1' | ch > '3' & ch != 'q') return false;
        return true;
    }

    private static boolean isFileExists(String filename) {
        File chack;
        try {
            chack = File.createTempFile(filename, ".txt");

            boolean exists = chack.exists();
            if (exists) return true;
            else {
                System.out.println("file doesn't exists");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void run(String mainFile) throws IOException {

        Word obj = new Word();
        ReadingOfFile readingOfList = new ReadingOfFile();
        Spelling spelling = new Spelling();
        Menu menu = new Menu();
        ReadingOfFile reading = new ReadingOfFile();
        reading.readMainFile(mainFile, WORK_FILE);
        reading.readFile1(WORK_FILE);
        char choice;
        do {
            menu.showMenu();
            choice = menu.takeChoise();
        } while (!isChoiceValid(choice));
    }
}


