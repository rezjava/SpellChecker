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
    LinkedList <Word> readMainFile (String filepath){

        return
    }
}


