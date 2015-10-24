package com.ele.data.analysis.processor;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;


/**
 * Created by majun on 15/10/23.
 */
public class FileHandlerTest {
    @Test
    public void testName() throws Exception {
        transform();
    }
    public static void transform(){
        try {
            BufferedReader bf = new BufferedReader(new FileReader("location.txt"));
            String valueString = null;
            while ((valueString=bf.readLine())!=null){
                System.out.println(valueString);
            }
            System.out.println("end");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}