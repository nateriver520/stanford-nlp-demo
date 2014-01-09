package com.nlp.demo.extract_content;

import java.net.URL;

import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.sax.BoilerpipeSAXInput;
import de.l3s.boilerpipe.sax.HTMLDocument;
import de.l3s.boilerpipe.sax.HTMLFetcher;


public class ExtractContent {
    public void content(String url) {
        try {
            final HTMLDocument htmlDoc = HTMLFetcher.fetch(new URL(url));
            final TextDocument doc = new BoilerpipeSAXInput(htmlDoc.toInputSource()).getTextDocument();
            String title = doc.getTitle();

            String content = ArticleExtractor.INSTANCE.getText(doc);

            System.out.println("[title] " + title);
            System.out.println("[content] " + content);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
       ExtractContent ec = new ExtractContent();

       //ec.content("http://shine.yahoo.com/pets/10-healthiest-human-foods-dogs-142800057.html");
       ec.content("http://shine.yahoo.com/parenting/awesome-dad-styles-daughter-39-hair-breaks-internet-204400163.html");
    }
}
