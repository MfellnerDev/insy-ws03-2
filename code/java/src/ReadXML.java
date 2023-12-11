import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;

public class ReadXML {
    public static void main(String[] args) {
        try  {
            File file = new File("src/book_store.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();


            // Greife auf alle Buch-Elemente zu
            Element bookstoreElement = document.getDocumentElement();

            NodeList bookList = bookstoreElement.getElementsByTagName("book");

            // Iteriere über die Buch-Elemente
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;

                    // Lese Werte aus den Buch-Elementen
                    String category = bookElement.getAttribute("category");
                    String title = getElementValue(bookElement, "title");
                    String author = getElementValue(bookElement, "author");
                    String year = getElementValue(bookElement, "year");
                    String price = getElementValue(bookElement, "price");

                    // Gib die Informationen aus
                    System.out.println("Category: " + category);
                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                    System.out.println("Year: " + year);
                    System.out.println("Price: " + price);
                    System.out.println("------------------------");
                }
            }

        } catch (Exception e) {
            System.err.println("Nuhh uhh, fehler passiert.");
            e.printStackTrace();
        }

    }

    private static String getElementValue(Element parentElement, String elementName) {
        NodeList nodeList = parentElement.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
