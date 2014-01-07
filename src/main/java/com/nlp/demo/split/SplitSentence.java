package com.nlp.demo.split;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.DocumentPreprocessor;

import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * split sentence
 */
public class SplitSentence {
    public List<String> split(String paragraph){
        Reader reader = new StringReader(paragraph);
        DocumentPreprocessor dp = new DocumentPreprocessor(reader);

        List<String> sentenceList = new LinkedList<>();
        Iterator<List<HasWord>> it = dp.iterator();

        while (it.hasNext()) {
            StringBuilder sentenceSb = new StringBuilder();
            List<HasWord> sentence = it.next();
            for (HasWord token : sentence) {
                if(sentenceSb.length()>1) {
                    sentenceSb.append(" ");
                }
                sentenceSb.append(token);
            }
            sentenceList.add(sentenceSb.toString());
        }
        return sentenceList;
    }


    public static void main(String[] args) {
        String text = "Being that this is the first time Roberts has mentioned her girlfriend on television since coming out in a Facebook post on Dec. 29, Stephanopoulos took the opportunity to address the exciting news. He hinted that her relationship with Laign was a well-known fact among her close colleagues and that he hoped her experience coming out was positive.";
        SplitSentence spliter = new SplitSentence();
        List<String> sentences = spliter.split(text);

        for(String sentence : sentences){
            System.out.println(sentence);
        }
    }

}
