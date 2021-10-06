import java.io.*;
import java.util.Collection;
import java.util.Locale;

public class DictionaryManagement {
    /**
     * Hàm thêm từ vòa từ điển sẵn có.
     *
     * @param dictionary từ điển sẵn có.
     * @param word từ cần thêm vào
     */
    public static void insertFromCommandline(Dictionary dictionary, Word word) {
        if (dictionary.word.containsKey(word.getWord_target())==false)
            dictionary.word.put(word.getWord_target(), word.getWord_explain());
    }
    public static void dictionaryExportToFile(Dictionary dictionary){
        try {

            FileOutputStream fileOutputStream = new FileOutputStream("dictionaries.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            Collection<String> data= dictionary.word.keySet();
            for (String key : data)
            {
                bufferedWriter.write(key);
                bufferedWriter.write("\t\t");
                bufferedWriter.write(dictionary.word.get(key));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public static void insertFromFile(Dictionary dictionary){
        try {
            FileInputStream fis=new FileInputStream("dictionaries.txt");
            InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
            BufferedReader br=new BufferedReader(isr);
            String line=br.readLine();
            while (line!=null)
            {
                String arr[]=line.split("\t\t");
                dictionary.word.put(arr[0],arr[1]);
                line=br.readLine();
            }
            br.close();
            isr.close();;
            fis.close();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public static String dictionaryLookUp(Dictionary dictionary, String key){
        key=key.toLowerCase();
        if (dictionary.word.containsKey(key))
        {
            return dictionary.word.get(key);
        }
        else
            return null;
    }
}