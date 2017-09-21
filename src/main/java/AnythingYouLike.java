/** Scrapes data from web
 */
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */


public class AnythingYouLike {

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] args) {
        String url = ("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(urlToString(url));

        String str1 = urlToString(url);
        String[] wordArray = str1.trim().split("\\s+");
        int wordCount = wordArray.length;

        System.out.println("Words:" + wordCount);

        String url2 = ("https://www.bls.gov/tus/charts/chart9.txt");
        String str2 = urlToString(url2);
        String[] wordArray2 = str2.trim().split("\\s+");
        int wordCount2 = wordArray2.length;

        System.out.println("Words:" + wordCount2);

        String url3 = ("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt");
        String str3 = urlToString(url3);
        String[] wordArray3 = str3.trim().split("\\s+");
        int wordCount3 = wordArray3.length;

        System.out.println("Words:" + wordCount3);

        String input = urlToString(url);
        input = input.toLowerCase();
        int index = input.indexOf("prince");
        int count = 0;
        while (index != -1) {
            count++;
            input = input.substring(index + 1);
            index = input.indexOf("prince");
        }
        System.out.print("Number of times *prince* is printed:" + count);

    }
}
