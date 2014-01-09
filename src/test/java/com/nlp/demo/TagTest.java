package com.nlp.demo;


import com.nlp.demo.tag.Tag;
import org.junit.Test;

public class TagTest {
    @Test
    public void testTag() throws Exception {
        String text = Utils.getResourcePage();

        Tag tagger = new Tag();
        String res = tagger.tag(text);
        String[] words = res.split(" ");

        for(String word : words){
            String[] attrs = word.split("_");
            if(attrs.length == 2){
                System.out.print(attrs[0] + "    " + attrs[1]);
            }
        }
    }
}
