import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

/* all things for reading words as a list */
public class ReadingOfList {

    public void readFile1(String filepath) {
        try {
            FileInputStream fis = new FileInputStream(filepath);
            LinkedList<Word> objectList = new LinkedList<Word>();
            boolean cont = true;
            while (cont) {
                try (ObjectInputStream input = new ObjectInputStream(fis)) {
                    Object obj = input.readObject();
                    if (obj != null) {
                        objectList.add((Word) obj);
                    } else {
                        cont = false;
                    }
                }
            }
            for (Word k : objectList) {
                System.out.println(k.getEnglishWord() + k.getRussianWord());

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
