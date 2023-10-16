import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WebScraper {
    public static void main(String[] args) {
        String url = "https://example.com"; // Replace with the URL of the website you want to scrape.

        try {
            // Connect to the website and get the HTML document.
            Document document = Jsoup.connect(url).get();

            // Select the HTML elements containing article titles.
            Elements titleElements = document.select("h2.article-title"); // Adjust the selector to match the actual HTML structure.

            // Iterate through the selected elements and print the titles and links.
            for (Element titleElement : titleElements) {
                String title = titleElement.text();
                String link = titleElement.select("a").attr("href");
                System.out.println("Title: " + title);
                System.out.println("Link: " + link);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
