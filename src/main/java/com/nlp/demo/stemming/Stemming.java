package com.nlp.demo.stemming;

import com.nlp.demo.Utils;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.util.CoreMap;

/**
 * Stemming
 */
public class Stemming {
    protected static StanfordCoreNLP pipeline;

    public Stemming() {
        Properties props;
        props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma");
        pipeline = new StanfordCoreNLP(props);
    }

    public List<String> lemmatize(String documentText)
    {
        List<String> lemmas = new LinkedList<String>();
        Annotation document = new Annotation(documentText);
        pipeline.annotate(document);
        List<CoreMap> sentences = (List<CoreMap>) document.get(SentencesAnnotation.class);
        for(CoreMap sentence: sentences) {
            for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
                lemmas.add(token.get(LemmaAnnotation.class));
            }
        }
        return lemmas;
    }


    public static void main(String[] args) {
        System.out.println("Starting Stanford Lemmatizer");
        String text = Utils.getResourcePage();

        Stemming slem = new Stemming();
        System.out.println(slem.lemmatize(text));
    }
}
