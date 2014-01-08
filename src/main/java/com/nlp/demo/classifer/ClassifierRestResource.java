package com.nlp.demo.classifer;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;

import java.util.HashMap;
import java.util.List;


public class ClassifierRestResource {
    private static ClassifierConfig config = new ClassifierConfig();
    private CRFClassifier<CoreLabel> classifier;

    private void init(){
        config.postConstruct();
        classifier = config.classifier();
    }

    public HashMap<String,String> findNer(String text) {
        init();
        List<List<CoreLabel>> classify = classifier.classify(text);
        HashMap<String,String> results = new HashMap<>();
        for (List<CoreLabel> coreLabels : classify) {
            for (CoreLabel coreLabel : coreLabels) {
                String word = coreLabel.word();
                String answer = coreLabel.get(CoreAnnotations.AnswerAnnotation.class);
                if(!"O".equals(answer)){
                    results.put(word, answer);
                }

            }
        }
        return results;
    }
}
