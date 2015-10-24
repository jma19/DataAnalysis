package com.ele.data.analysis.processor;

import com.ele.data.analysis.Entity.LocationPeopleInfo;
import com.ele.data.analysis.api.DataAnalysisService;
import com.ele.data.analysis.csv.CsvColumnMapping;
import com.ele.data.analysis.csv.CsvMapper;
import com.google.common.collect.Lists;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * Created by majun on 15/10/23.
 */
public class DataAnalysisProcessor implements DataAnalysisService {
    private final static String header = "id,type,name,location,xLong,yLong,hour1,hour2,hour3,hour4,hour5,hour6,hour7,hour8,hour9,hour10,hour11,hour12,hour13,hour14,hour15,hour16,hour17,hour18,hour19,hour20,hour21,hour22,hour23,hour24\n";
    private final static String filePath = "location1.txt";
    private static List<LocationPeopleInfo> locationInfos;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh");
    private final static Map<String, Function<LocationPeopleInfo, String>> stringFunctionHashMap = new HashMap<>();

    public DataAnalysisProcessor() {
        locationInfos = getData();
        if (locationInfos.size() == 0) {
            System.out.println("loading file failed");
        }
    }

    public List getTopNList(Date date, int n) {
        String hour = getHour(date);
        System.out.println(hour);
        List<LocationPeopleInfo> collect = locationInfos.stream().
                sorted(Comparator.comparing(stringFunctionHashMap.get(hour)).reversed()).collect(toList());
        ArrayList<LocationPeopleInfo> result = Lists.newArrayList();
        for (int index = 0; index < n; index++) {
            LocationPeopleInfo locationPeopleInfo = collect.get(index);
            locationPeopleInfo.setIndex("" + index + 1);
            result.add(locationPeopleInfo);
        }
        return result;
    }

    private String getHour(Date date) {
        String format = simpleDateFormat.format(date);
        if (format.equals("00") || format.equals("0")) {
            return "24";
        }
        return format;
    }

    public List getWarningLocationList(Date date) {
        String courrentTime = simpleDateFormat.format(date);
        if (courrentTime.equals("1")) {
            return new ArrayList<>();
        }
        return locationInfos.stream().filter(locationPeopleInfo -> isWarn(locationPeopleInfo, courrentTime)).collect(toList());

    }

    private boolean isWarn(LocationPeopleInfo locationPeopleInfo, String courrentTime) {
        String priorTime = String.valueOf(Integer.parseInt(courrentTime) - 1);
        String peopleNumberAtTime = getPeopleNumberAtTime(courrentTime, locationPeopleInfo);
        float peopleNumberAtCurrentTime = Integer.valueOf(peopleNumberAtTime);
        String peopleNumberAtTime1 = getPeopleNumberAtTime(priorTime, locationPeopleInfo);
        Integer integer = Integer.valueOf(peopleNumberAtTime1);
        float diff = peopleNumberAtCurrentTime - integer;
        return (diff / peopleNumberAtCurrentTime) > 0.5 ? true : false;
    }

    private List getData() {
        StringReader reader = new StringReader(header + FileHandler.readFrom(filePath).toString());
        CsvMapper<LocationPeopleInfo> locationPeopleInfoCsvMapper = new CsvMapper(LocationPeopleInfo.class);
        return locationPeopleInfoCsvMapper
                .withMapping(new CsvColumnMapping(LocationPeopleInfo.class))
                .fromCsv(reader);
    }

    public static void main(String[] args) {
        DataAnalysisProcessor dataAnalysisProcessor = new DataAnalysisProcessor();
        List<LocationPeopleInfo> topNList = dataAnalysisProcessor.getTopNList(new Date(), 20);
        for(LocationPeopleInfo locationPeopleInfo:topNList){
            System.out.println(locationPeopleInfo);
        }
        System.out.println("======================");
        List<LocationPeopleInfo> warningLocationList = dataAnalysisProcessor.getWarningLocationList(new Date());
        for(LocationPeopleInfo locationPeopleInfo:warningLocationList){
            System.out.println(locationPeopleInfo);
        }
    }

    private String getPeopleNumberAtTime(String format, LocationPeopleInfo locationPeopleInfo) {
        if (format.equals("01")||format.equals("1")) {
            return locationPeopleInfo.getHour1();
        } else if (format.equals("02")||format.equals("2")) {
            return locationPeopleInfo.getHour2();
        } else if (format.equals("03")||format.equals("3")) {
            return locationPeopleInfo.getHour3();
        } else if (format.equals("04")||format.equals("4")) {
            return locationPeopleInfo.getHour4();
        } else if (format.equals("05")||format.equals("5")) {
            return locationPeopleInfo.getHour5();
        } else if (format.equals("06")||format.equals("6")) {
            return locationPeopleInfo.getHour6();
        } else if (format.equals("07")||format.equals("7")) {
            return locationPeopleInfo.getHour7();
        } else if (format.equals("08")||format.equals("8")) {
            return locationPeopleInfo.getHour8();
        } else if (format.equals("09")||format.equals("9")) {
            return locationPeopleInfo.getHour9();
        } else if (format.equals("10")) {
            return locationPeopleInfo.getHour10();
        } else if (format.equals("11")) {
            return locationPeopleInfo.getHour11();
        } else if (format.equals("12")) {
            return locationPeopleInfo.getHour12();
        } else if (format.equals("13")) {
            return locationPeopleInfo.getHour13();
        } else if (format.equals("14")) {
            return locationPeopleInfo.getHour14();
        } else if (format.equals("15")) {
            return locationPeopleInfo.getHour15();
        } else if (format.equals("16")) {
            return locationPeopleInfo.getHour16();
        } else if (format.equals("17")) {
            return locationPeopleInfo.getHour17();
        } else if (format.equals("18")) {
            return locationPeopleInfo.getHour18();
        } else if (format.equals("19")) {
            return locationPeopleInfo.getHour19();
        } else if (format.equals("20")) {
            return locationPeopleInfo.getHour20();
        } else if (format.equals("21")) {
            return locationPeopleInfo.getHour21();
        } else if (format.equals("22")) {
            return locationPeopleInfo.getHour22();
        } else if (format.equals("23")) {
            return locationPeopleInfo.getHour23();
        } else if (format.equals("24")) {
            return locationPeopleInfo.getHour24();
        }
        return null;
    }

    static {
        stringFunctionHashMap.put("01", LocationPeopleInfo::getHour1);
        stringFunctionHashMap.put("02", LocationPeopleInfo::getHour2);
        stringFunctionHashMap.put("03", LocationPeopleInfo::getHour3);
        stringFunctionHashMap.put("04", LocationPeopleInfo::getHour4);
        stringFunctionHashMap.put("05", LocationPeopleInfo::getHour5);
        stringFunctionHashMap.put("06", LocationPeopleInfo::getHour6);
        stringFunctionHashMap.put("07", LocationPeopleInfo::getHour7);
        stringFunctionHashMap.put("08", LocationPeopleInfo::getHour8);
        stringFunctionHashMap.put("09", LocationPeopleInfo::getHour9);
        stringFunctionHashMap.put("10", LocationPeopleInfo::getHour10);
        stringFunctionHashMap.put("11", LocationPeopleInfo::getHour11);
        stringFunctionHashMap.put("12", LocationPeopleInfo::getHour12);
        stringFunctionHashMap.put("13", LocationPeopleInfo::getHour13);
        stringFunctionHashMap.put("14", LocationPeopleInfo::getHour14);
        stringFunctionHashMap.put("15", LocationPeopleInfo::getHour15);
        stringFunctionHashMap.put("16", LocationPeopleInfo::getHour16);
        stringFunctionHashMap.put("17", LocationPeopleInfo::getHour17);
        stringFunctionHashMap.put("18", LocationPeopleInfo::getHour18);
        stringFunctionHashMap.put("19", LocationPeopleInfo::getHour19);
        stringFunctionHashMap.put("20", LocationPeopleInfo::getHour20);
        stringFunctionHashMap.put("21", LocationPeopleInfo::getHour21);
        stringFunctionHashMap.put("22", LocationPeopleInfo::getHour22);
        stringFunctionHashMap.put("23", LocationPeopleInfo::getHour23);
        stringFunctionHashMap.put("24", LocationPeopleInfo::getHour24);
    }
}
