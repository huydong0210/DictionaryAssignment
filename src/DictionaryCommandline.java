import java.util.Collection;
import java.util.Locale;
import java.util.Scanner;

public class DictionaryCommandline {
    /**
     * hàm in ra danh sách từ điển.
     *
     * @param dictionary từ điển có sẵn.
     */
    public static void showAllWords(Dictionary dictionary) {
        System.out.printf("%-15s|%-20s|%-20s\n", "No", "English", "Vietnamese");
        Collection<String> word = dictionary.word.keySet();
        int i = 0;
        for (String data : word) {
            i++;
            System.out.printf("%-15d|%-20s|%-20s\n", i, data, dictionary.word.get(data));
        }

    }

    /**
     * các dòng lệnh commandline.
     *
     * @param dictionary từ điển có sẵn.
     */
    public static void dictionaryBasic(Dictionary dictionary) {
        while (true) {
            System.out.println("1. Thêm từ vào từ điển");
            System.out.println("2. In ra toàn bộ từ trong từ điển");
            System.out.println("3. Tra cứu từ điển");
            System.out.println("0. Thoát khỏi chương trình ");
            System.out.println("Nhập giá trị tương ứng với hành động của bạn");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            while (!(choice == 1 || choice == 2 || choice == 3 || choice == 0)) {
                System.out.println("Bạn nhập sai, mời bạn nhập lại");
                choice = scanner.nextInt();
            }
            if (choice == 1) {
                Word word = new Word();
                System.out.println("Mời bạn nhập từ tiếng anh và nghĩa của chúng");
                scanner.nextLine();
                word.setWord_target(scanner.nextLine().toLowerCase());
                word.setWord_explain(scanner.nextLine().toLowerCase());
                DictionaryManagement.insertFromCommandline(dictionary, word);
                System.out.println();
            }
            if (choice == 2) {
                DictionaryCommandline.showAllWords(dictionary);
            }
            if (choice ==3 ){
                System.out.println("nhập từ tiếng anh mà bạn muốn tra :");
                scanner.nextLine();
                String s=scanner.nextLine();
                String result=DictionaryManagement.dictionaryLookUp(dictionary,s);
                if (result==null)
                    System.out.println("khong co tu kia");
                else
                    System.out.println(result);
            }
            if (choice == 0) {
                DictionaryManagement.dictionaryExportToFile(dictionary);
                break;
            }
        }
    }

}