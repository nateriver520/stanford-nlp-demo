package com.nlp.demo.classifer;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;


public class ClassifierConfig {
    private String serializedClassifier = "classifiers/english.all.3class.distsim.crf.ser.gz";
    private CRFClassifier<CoreLabel> classifier;

    public void postConstruct() {
        this.classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);
    }

    public CRFClassifier<CoreLabel> classifier() {
        return classifier;
    }
}
