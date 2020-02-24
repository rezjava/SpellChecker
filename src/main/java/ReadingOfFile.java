import java.io.*;
import java.util.LinkedList;

public class ReadingOfFile {

    // reading "mainfile" line by line and writing to another file "file1" as LinkedList<Word>
    public void readMainFile(String filepathForRead, String filepathForWrite) {
        LinkedList<String> listOfWords = new LinkedList<String>();
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
                for (int i = positionOfi + 2; i < line.length(); i++) {
                    rw = rw + line.charAt(i);
                }
                Word objForWriting = new Word(countOfWord, 0, ew, rw); //
                EncoderDecoderJSON coder = new EncoderDecoderJSON();
                String coderString = coder.encoderToJSON(objForWriting);
                listOfWords.add(index++, coderString);
                countOfWord++;
                line = reader.readLine();
            }
            objstr.writeObject(listOfWords);
            reader.close();
            objstr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile1(String filepath) {
        try {
            FileInputStream fis = new FileInputStream(filepath);
            LinkedList<String> objectList = new LinkedList<String>();
            boolean cont = true;
            int i = 0;
            while (cont) {
                try (ObjectInputStream input = new ObjectInputStream(fis)) {
                    Object obj = input.readObject();
                    if (obj != null) {
                        objectList.add(i++, (String) obj);
                        //     System.out.println(obj);
                    } else {
                        cont = false;
                    }
                }
            }
            fis.close();
            for (String k : objectList) {
                System.out.print(k.toString());
                System.out.println();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

