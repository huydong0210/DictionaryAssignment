import java.util.Locale;

public class MyTest {
    public static void main(String[] args) {
        Dictionary dictionary=new Dictionary();
        DictionaryManagement.insertFromFile(dictionary);
        DictionaryCommandline.dictionaryBasic(dictionary);

    }
}