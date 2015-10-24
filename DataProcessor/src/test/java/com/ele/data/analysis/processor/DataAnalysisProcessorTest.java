package com.ele.data.analysis.processor;

import com.ele.data.analysis.Entity.LocationPeopleInfo;
import org.junit.Test;

import java.util.Date;
import java.util.List;


/**
 * Created by majun on 15/10/24.
 */
public class DataAnalysisProcessorTest {
    @Test
    public void should_get_top_20_people_locations() throws Exception {

        DataAnalysisProcessor dataAnalysisProcessor = new DataAnalysisProcessor();
        List<LocationPeopleInfo> topNList = dataAnalysisProcessor.getTopNList(new Date(), 20);
        for (LocationPeopleInfo locationPeopleInfo : topNList) {
            System.out.println(locationPeopleInfo);
        }

    }

    @Test
    public void testName() throws Exception {
        DataAnalysisProcessor dataAnalysisProcessor = new DataAnalysisProcessor();
        List<LocationPeopleInfo> warningLocationList = dataAnalysisProcessor.getWarningLocationList(new Date(),3000);
        for (LocationPeopleInfo locationPeopleInfo : warningLocationList) {
            System.out.println(locationPeopleInfo);

        }

    }
}