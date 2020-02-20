import java.io.*;
import java.util.LinkedList;

public class Word implements Serializable {
    private int idWord;         //for counting words
    private int priority;       //for counting current amount of mistakes in this word
    private String englishWord;
    private String russianWord;

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

    // reading "mainfile" line by line and writing to another file "file1" as LinkedList<Word>
    public void readMainFile(String filepathForRead, String filepathForWrite) {
        LinkedList<Word> listOfWords = new LinkedList<Word>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepathForRead), "UTF-8"));
            ObjectOutputStream objstr = new ObjectOutputStream(new FileOutputStream(filepathForWrite));
            String line = reader.readLine();
            int positionOfi = 0;
            int index = 0;
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
