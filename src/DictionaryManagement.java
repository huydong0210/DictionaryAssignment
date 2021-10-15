import java.io.*;
import java.util.Collection;

public class DictionaryManagement {
    /**
     * Hàm thêm từ vòa từ điển sẵn có.
     *
     * @param word từ cần thêm vào
     */
    public static void insertWordToDictionary( Word word) {
        if (Dictionary.word.containsKey(word.getWord_target())==false)
            Dictionary.word.put(word.getWord_target(), word.getWord_explain());
    }

    /**
     * xuất từ điển ra file.
     *
     */
    public static void dictionaryExportToFile(){
        try {

            FileOutputStream fileOutputStream = new FileOutputStream("dictionaries.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            Collection<String> data= Dictionary.word.keySet();
            for (String key : data)
            {
                bufferedWriter.write(key);
                bufferedWriter.write("\t\t");
                bufferedWriter.write(Dictionary.word.get(key));
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

    /**
     * nhập từ điển vòa từ file.
     *
     */
    public static void insertFromFile(){
        try {

            FileInputStream fis=new FileInputStream("dictionaries.txt");
            InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
            BufferedReader br=new BufferedReader(isr);
            String line=br.readLine();
            while (line!=null)
            {
                String arr[]=line.split("\t\t");
                Dictionary.word.put(arr[0],arr[1]);
                Dictionary.word2.put(arr[1],arr[0]);
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

    /**
     * tra từ tiếng việt qua từ tiếng anh.
     *
     * @param key từ tiếng anh.
     * @return từ tiếng việt tương ứng nếu tìm thấy, Null nếu không tìm thấy.
     */
    public static String dictionaryLookUpWithEnglishWord(String key){
        key=key.toLowerCase();
        if (Dictionary.word.containsKey(key))
        {
            return Dictionary.word.get(key);
        }
        else
            return null;
    }

    /**
     * tra từ tiếng anh từ 1 từ tiếng việt
     *
     * @param dictionary2 từ điển phụ.
     * @param key từ tiếng việt.
     * @return trả về từ tiếng anh nếu thấy từ tiếng việt, nếu không trả về null.
     */
    public static String dictionaryLookupWithVietnameseWord(Dictionary dictionary2, String key){
        if (dictionary2.word.containsValue(key.toLowerCase()))
        {
            return dictionary2.word.get(key);
        }
        return null;
    }

    /**
     * hàm xóa 1 từ trong từ điển.
     *
     */
    public static void delete(String english){
        if (Dictionary.word.containsKey(english)){
            Dictionary.word.remove(english);
        }
    }

    /**
     * Hàm sửa đổi 1 từ trong từ điển
     *
     * @param newWordTarget từ tiếng anh mới.
     * @param newWordExplain từ tiếng việt mới.
     */
    public static void repairWordInDictionary(String newWordTarget, String newWordExplain){
        Dictionary.word.remove(newWordExplain);
        Dictionary.word.put(newWordTarget.toLowerCase(),newWordExplain.toLowerCase());
    }

}