

public class DictionaryManagement {
    /**
     * Hàm thêm từ vòa từ điển sẵn có.
     *
     * @param dictionary từ điển sẵn có.
     * @param word từ cần thêm vào
     */
    public static void insertFromCommandline(Dictionary dictionary, Word word) {
        dictionary.word.put(word.getWord_target(), word.getWord_explain());
    }

}
