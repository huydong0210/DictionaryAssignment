package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Controller implements Initializable {
    @FXML
    Button searchButton;

    @FXML
    TextField searchWord;

    @FXML
    WebView meaning;

    @FXML
    ListView<String> history;

    static Map<String, String> myDictionary;

    @FXML
    ListView<String> AllWord;

    public void
    readWord(){
        FileInputStream inputStream = null;
        Scanner scan = null;
        try {
            inputStream = new FileInputStream("Word.txt");
            scan = new Scanner(inputStream, "UTF-8");
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                int i = 0;
                String tmp;
                tmp = "";
                for (String w : line.split("<", 2)) {
                    if (i == 0) {
                        tmp = w;
                        AllWord.getItems().add(tmp);
                        i++;
                    } else {
                        myDictionary.put(tmp, '<' + w);
                    }
                }
            }
            if (scan.ioException() != null) {
                throw scan.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (scan != null) {
                scan.close();
            }
        }
    }

    public void InitAll(){
        readWord();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        history.setVisible(false);
        myDictionary = new HashMap<>();
        InitAll();
    }

    public void search_Word(){
        WebEngine webEngine = meaning.getEngine();
        history.setVisible(true);
        String w = searchWord.getText();
        w = w.toLowerCase();
        w = w.trim();
        if (!w.equals("")) {
            if (!myDictionary.containsKey(w)) {
                String t = "<html>NO WORD<br>add word to dictionary if you want</html>";
                webEngine.loadContent(t);
            } else {
                webEngine.loadContent(myDictionary.get(w));
                history.getItems().remove(w);
                history.getItems().add(0, w);
            }
        }
    }

    public void show_history(){
        history.setVisible(true);
    }

    public void history_view(){
        WebEngine webEngine = meaning.getEngine();
        String w = history.getSelectionModel().getSelectedItem();
        webEngine.loadContent(myDictionary.get(w));
        searchWord.setText(w);
        history.getItems().remove(w);
        history.getItems().add(0, w);
        history.setVisible(false);
    }

    public void AllWord_view(){
        WebEngine webEngine = meaning.getEngine();
        history.setVisible(false);
        String w = AllWord.getSelectionModel().getSelectedItem();
        webEngine.loadContent(myDictionary.get(w));
        searchWord.setText(w);
        history.getItems().remove(w);
        history.getItems().add(0, w);
    }
}
