package con.self.exercise.db.generate.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prime23 on 1/31/17.
 */
public final class NamesUtil {
    private NamesUtil(){
        // util class should be instantiated
    }

    public static List<String> firstNames() throws IOException {
        List<String> names = new ArrayList<>();
        Document doc = Jsoup.connect("https://www.babble.com/pregnancy/1000-most-popular-boy-names/").get();
        Elements list = doc.select("main li");
        for(Element e : list) {
            names.add(e.text());
        }
        doc = Jsoup.connect("https://www.babble.com/pregnancy/1000-most-popular-girl-names/").get();
        list = doc.select("main li");
        for(Element e : list) {
            names.add(e.text());
        }
        return names;
    }

    public static List<String> lastNames() throws IOException {
        List<String> names = new ArrayList<>();
        Document doc = Jsoup.connect("http://names.mongabay.com/data/1000.html").get();
        Elements list = doc.select("tr td:nth-child(1)");
        for(Element e : list) {
            String name = e.text();
            name = name.substring(0,1) + name.substring(1).toLowerCase();
            names.add(name);
        }
        return names;
    }
}
