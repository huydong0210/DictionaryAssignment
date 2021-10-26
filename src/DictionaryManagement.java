import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DictionaryManagement {

    public static void insertWord(Word word) {
        Connection connection = Sql.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO av(word, description, pronounce) VALUES (?, ?, ?)");
            preparedStatement.setString(1, word.getWord());
            preparedStatement.setString(2, word.getDescription());
            preparedStatement.setString(3, word.getPronounce());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void repairWord(Word word) {
        Connection connection = Sql.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE av Set word = ?, description = ?, pronounce = ? WHERE id = ?");
            preparedStatement.setString(1, word.getWord());
            preparedStatement.setString(2, word.getDescription());
            preparedStatement.setString(3, word.getPronounce());
            preparedStatement.setInt(4, word.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Word> dictionaryLookUp(String english) {
        Connection connection = Sql.getConnection();
        ArrayList<Word> words = new ArrayList<Word>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM av WHERE word like ?");
            preparedStatement.setString(1, english+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Word word = new Word(resultSet.getInt("id"),
                        resultSet.getString("word"),
                        resultSet.getString("description"),
                        resultSet.getString("pronounce"));
                words.add(word);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }

    public static void deleteWord(Word word) {
        Connection connection = Sql.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM av WHERE word = ?");
            preparedStatement.setString(1, word.getWord());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
