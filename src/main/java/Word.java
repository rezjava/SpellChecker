import java.io.*;

public class Word implements Serializable {
    private int idWord;         //for counting words
    private int priority;       //for counting current amount of mistakes in this word
    private String englishWord;
    private String russianWord;

   public Word(){
    }

   public Word(int id,int priority,String englishWord, String russianWord) {
        this.idWord = id;
        this.priority = priority;
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


    }



