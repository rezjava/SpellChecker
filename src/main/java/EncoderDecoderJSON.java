import com.google.gson.Gson;

public class EncoderDecoderJSON {
    public String encoderToJSON(Word obj){
        Gson gson = new Gson();
        String wordJSON = gson.toJson(obj);
       return wordJSON;
    }

    public void decoderToJSON(){

    }
}
