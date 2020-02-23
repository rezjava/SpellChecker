import java.io.*;
import java.util.LinkedList;

public class ReadingOfFile {

    // reading "mainfile" line by line and writing to another file "file1" as LinkedList<Word>
    public void readMainFile(String filepathForRead, String filepathForWrite) {
        LinkedList<Word> listOfWords = new LinkedList<Word>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepathForRead), "UTF-8"));
            ObjectOutputStream objstr = new ObjectOutputStream(new FileOutputStream(filepathForWrite));
            String line = reader.readLine();
            int positionOfi = 0;
            int index = 0;
            int countOfWord = 0;
            while (line != null) {
                String ew = "";
                String rw = "";
                for (int i = 0; i < line.length() - 1; i++) {
                    if (line.charAt(i) == '#') {
                        positionOfi = i;
                        break;
                    }
                }
                for (int i = 0; i < positionOfi - 1; i++) {
                    ew = ew + line.charAt(i);
                }
                for (int i = positionOfi + 2; i < line.length() - 1; i++) {
                    rw = rw + line.charAt(i);
                }
                Word objForWriting = new Word(countOfWord, 0, ew, rw);
                listOfWords.add(index++, objForWriting);
                objstr.writeObject(listOfWords);
                countOfWord++;
                line = reader.readLine();
            }
            reader.close();
            objstr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

