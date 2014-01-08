package com.nlp.demo;

import com.nlp.demo.classifer.ClassifierRestResource;
import org.junit.Test;

import java.util.HashMap;

public class ClassifierTest {

    @Test
    public void testClassify() throws Exception {
        ClassifierRestResource cr = new ClassifierRestResource();
        HashMap<String,String> res =  cr.findNer("Microsoft SCCM Windows Server 2012 Web Development Expert (SME3) at PSI Pax (Baltimore,MD) ");

        for(String key : res.keySet()){
            System.out.println("keyword is :" + key + " and classify result is :" + res.get(key));
        }
    }
}
