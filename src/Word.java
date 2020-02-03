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
    // reading mainfile lite by line and writing lines to LinkedList into file
    void readMainFile(String filepath) {
        LinkedList<Word> listOfWords = new  LinkedList<Word>();
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader("/home/ubuntu/IdeaProjects/ActiveVocabulary/maintext"));
            writer = new BufferedWriter(new FileWriter("/home/ubuntu/IdeaProjects/ActiveVocabulary/list1"));
            String line = reader.readLine();
            String ew = "";
            String rw = "";
            while (line != null) {

                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != '#') ew = ew + line.charAt(i);
                    else
                        continue;
                        rw = rw + line.charAt(i);
                }


               // System.out.println("english word is " + ew);
               //  System.out.println("russion word is " + rw);



                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


