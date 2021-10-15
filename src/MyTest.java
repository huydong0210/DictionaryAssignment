import java.util.Collection;

public class MyTest {

    public static void main(String[] args) {
        DictionaryManagement.insertFromFile();
        Gui gui=new Gui();
        gui.showWindow();

    }
}