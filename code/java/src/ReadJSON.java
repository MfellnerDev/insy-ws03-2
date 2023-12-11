import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJSON {

    public static void main(String[] args) {
        try {
            // Read the content of the JSON file into a String
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/book_store.json")));

            JSONObject jsonObject = new JSONObject(jsonContent);

            JSONObject bookstore = jsonObject.getJSONObject("bookstore");

            // Get the array of books
            JSONArray books = bookstore.getJSONArray("book");

            // iterate through each book and print its detail
            for (int i = 0; i < books.length(); i++) {
                JSONObject book = books.getJSONObject(i);
                System.out.println("Title: " + book.getString("title"));
                System.out.println("Author: " + book.getString("author"));
                System.out.println("Year: " + book.getInt("year"));
                System.out.println("Price: $" + book.getDouble("price"));
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Nuhh uhh, fehler passiert");
            e.printStackTrace();
        }
    }
}
