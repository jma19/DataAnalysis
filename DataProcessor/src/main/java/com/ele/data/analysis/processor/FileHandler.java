package com.ele.data.analysis.processor;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.io.*;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class FileHandler {
    public static StringBuffer readFrom(String fileName) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
            String valueString = null;
            while ((valueString = bf.readLine()) != null) {
                stringBuffer.append(valueString + "\n");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return stringBuffer;
    }

    public static void transform() {
        try {
            int count=0;
            BufferedReader bf = new BufferedReader(new FileReader("location.txt"));
            PrintWriter printWriter=new PrintWriter(new FileWriter("location2.txt"));
            String valueString = null;
            while ((valueString = bf.readLine()) != null) {
                count++;
                String processedMessage = getProcessedMessage(valueString,count);
                System.out.println(processedMessage);
                printWriter.println(processedMessage);
            }
            printWriter.flush();
            printWriter.close();
            bf.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String getProcessedMessage(String string,int i) {
        StringTokenizer tokenizer = new StringTokenizer(string);
        ArrayList<String> objects = Lists.newArrayList();
        while (tokenizer.hasMoreElements()){
            objects.add((String)tokenizer.nextElement());
        }
        int size = objects.size();
        if(size==31){
            objects.remove(0);
        }
        if(size==32){
            objects.remove(0);
            objects.remove(0);
        }
//        System.out.println(objects.size());
        return Joiner.on(",").join(objects);
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new FileReader("location.txt"));
        transform();
        File file = new File("location1.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
//        String valueString = null;
//        while ((valueString = bf.readLine()) != null) {
//            System.out.println(valueString);
//        }
    }
}
