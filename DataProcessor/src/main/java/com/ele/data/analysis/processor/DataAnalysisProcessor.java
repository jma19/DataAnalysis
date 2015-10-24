package com.ele.data.analysis.processor;

import com.ele.data.analysis.Entity.LocationPeopleInfo;
import com.ele.data.analysis.api.DataAnalysisService;
import com.ele.data.analysis.csv.CsvColumnMapping;
import com.ele.data.analysis.csv.CsvMapper;
import com.google.common.collect.Lists;

import java.io.StringReader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

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

    public List getWarningLocationList(Date date, int threshold) {
        String courrentTime = simpleDateFormat.format(date);
        if (courrentTime.equals("1")) {
            return new ArrayList<>();
        }
        return locationInfos.stream().filter(locationPeopleInfo -> isWarn(locationPeopleInfo, courrentTime, threshold)).collect(toList());
    }


    private boolean isWarn(LocationPeopleInfo locationPeopleInfo, String courrentTime, int threshold) {
        String priorTime = String.valueOf(Integer.parseInt(courrentTime) - 1);
        String peopleNumberAtTime = getPeopleNumberAtTime(courrentTime, locationPeopleInfo);
        float peopleNumberAtCurrentTime = Integer.valueOf(peopleNumberAtTime);
        String peopleNumberAtTime1 = getPeopleNumberAtTime(priorTime, locationPeopleInfo);
        Integer integer = Integer.valueOf(peopleNumberAtTime1);
        float diff = peopleNumberAtCurrentTime - integer;
        return (diff / peopleNumberAtCurrentTime) > 0.5 && peopleNumberAtCurrentTime >= threshold ? true : false;
    }

    private List getData() {
        StringReader reader = new StringReader(header + FileHandler.readFrom(filePath).toString());
        CsvMapper<LocationPeopleInfo> locationPeopleInfoCsvMapper = new CsvMapper(LocationPeopleInfo.class);
        return locationPeopleInfoCsvMapper
                .withMapping(new CsvColumnMapping(LocationPeopleInfo.class))
                .fromCsv(reader);
    }

    private  String getPeopleNumberAtTime(String time, LocationPeopleInfo locationPeopleInfo) {
        String methodName = "getHour" + Integer.parseInt(time);
        try {
            Method declaredMethod = LocationPeopleInfo.class.getDeclaredMethod(methodName);
            return (String) declaredMethod.invoke(locationPeopleInfo);
        } catch (Exception e) {
            e.printStackTrace();
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
