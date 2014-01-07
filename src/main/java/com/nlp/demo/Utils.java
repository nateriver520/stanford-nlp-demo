package com.nlp.demo;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Utils {

    public static String getResourcePage(){

        StringBuilder sb = new StringBuilder();
        try {
            InputStream is = Utils.class.getResourceAsStream("/page.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

            while (br.ready()){
                sb.append(br.readLine());
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("cannot get page");
        }

        return sb.toString();
    }
}
