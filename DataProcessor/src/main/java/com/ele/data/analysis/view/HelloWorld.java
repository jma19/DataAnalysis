package com.ele.data.analysis.view;

import com.ele.data.analysis.Entity.LocationPeopleInfo;
import com.ele.data.analysis.api.DataAnalysisService;
import com.ele.data.analysis.processor.DataAnalysisProcessor;

import javax.swing.table.DefaultTableModel;
import java.applet.Applet;
import java.awt.*;

public class HelloWorld extends Applet {

    private DataAnalysisService<LocationPeopleInfo> dataAnalysisService=new DataAnalysisProcessor();
    public void paint(Graphics g) {
        //向外输出的字符串
        g.drawString("Hello HelloWorldd!", 5, 35);

        DefaultTableModel defaultTableModel = new DefaultTableModel();
    }


}