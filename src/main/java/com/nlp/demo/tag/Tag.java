package com.nlp.demo.tag;

import com.nlp.demo.Utils;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

/**
 * Tag
 */
public class Tag {

   public String tag(String text){
       MaxentTagger tagger = new MaxentTagger("models/english-bidirectional-distsim.tagger");
       return tagger.tagString(text);
   }

    public static void main(String[] args) {
        String text = Utils.getResourcePage();

        Tag tagger = new Tag();
        String res = tagger.tag(text);
        System.out.println(res);
    }
}
