import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Word implements Serializable {
    private int idWord;         //jast for counting words
    private String englishWord;
    private String russianWord;
    private int priority;       //it's a current amount of mistakes in this word

    Word() {
        this.priority = 0;
    }

    Word(String englishWord, String russianWord) {
        this.englishWord = englishWord;
        this.russianWord = russianWord;
    }

    public int getIdWord() {
        return idWord;
    }

    public void setIdWord(int idWord) {
        this.idWord = idWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getRussianWord() {
        return russianWord;
    }

    public void setRussianWord(String russianWord) {
        this.russianWord = russianWord;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    // reading mainfile line by line and writing to LinkedList and to file
    void readMainFile(File filepathForRead, File filepathForWrite) {
        LinkedList<Word> listOfWords = new LinkedList<Word>();
      //  BufferedReader reader = null;
        try {
            // reader = new BufferedReader(new InputStreamReader(filepathForRead),"UTF-8");
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepathForRead), "UTF8"));
            ObjectOutputStream objstr = new ObjectOutputStream(new FileOutputStream(filepathForWrite));
            String line = reader.readLine();
            String ew = "";
            String rw = "";
            int positionOfi = 0;
            int index = 0;
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '#') {
                        positionOfi = i;
                    }
                }
                for (int i = 0; i < positionOfi; i++) {
                    ew = ew + line.charAt(i);
                }
                for (int i = positionOfi + 1; i < line.length(); i++) {
                    rw = rw + line.charAt(i);
                }
                Word objForWriting = new Word(ew, rw);
                listOfWords.add(index++, objForWriting);
                objstr.writeObject(listOfWords);
                line = reader.readLine();
            }
            reader.close();
            objstr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
