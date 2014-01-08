package com.nlp.demo.sentiment;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class SentimentAnalyzer {

    public Integer findSentiment(String line) {

        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        int mainSentiment = 0;
        if (line != null && line.length() > 0) {
            int longest = 0;
            Annotation annotation = pipeline.process(line);
            for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
                Tree tree = sentence.get(SentimentCoreAnnotations.AnnotatedTree.class);
                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
                String partText = sentence.toString();
                if (partText.length() > longest) {
                    mainSentiment = sentiment;
                    longest = partText.length();
                }

            }
        }

        return mainSentiment;
    }

    public static void main(String[] args) {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();

        Integer res =  analyzer.findSentiment("Great win yesterday in the FA Cup! Love the north London derby! Back in the hat we go for the 4th round.....AFC");
        Integer res1 =  analyzer.findSentiment("click here for your Sachin Tendulkar personalized digital autograph.");
        Integer res2 =  analyzer.findSentiment("I am very happy today.");
        Integer res3 =  analyzer.findSentiment("I feel sad. It's rainy again.");
        Integer res4 =  analyzer.findSentiment("Shame on u, bad boy.");
        Integer res5 =  analyzer.findSentiment("It's great to see u again.");

        System.out.println("Result is " + res);
        System.out.println("Result is " + res1);
        System.out.println("Result is " + res2);
        System.out.println("Result is " + res3);
        System.out.println("Result is " + res4);
        System.out.println("Result is " + res5);

    }
}
