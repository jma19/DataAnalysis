package com.ele.data.analysis.Entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by majun on 15/10/23.
 */
public class LocationPeopleInfo {

    private String index;
    private String id;
    private String type;
    private String name;
    private String location;
    private String xLong;
    private String yLong;
    private String hour1;
    private String hour2;
    private String hour3;
    private String hour4;
    private String hour5;
    private String hour6;
    private String hour7;
    private String hour8;
    private String hour9;
    private String hour10;
    private String hour11;
    private String hour12;
    private String hour13;
    private String hour14;
    private String hour15;
    private String hour16;
    private String hour17;
    private String hour18;
    private String hour19;
    private String hour20;
    private String hour21;
    private String hour22;
    private String hour23;
    private String hour24;

    public String getId() {
        return id;
    }

    public String getHour15() {
        return hour15;
    }

    public void setHour15(String hour15) {
        this.hour15 = hour15;
    }

    public String getHour16() {
        return hour16;
    }

    public void setHour16(String hour16) {
        this.hour16 = hour16;
    }

    public String getHour17() {
        return hour17;
    }

    public void setHour17(String hour17) {
        this.hour17 = hour17;
    }

    public String getHour18() {
        return hour18;
    }

    public void setHour18(String hour18) {
        this.hour18 = hour18;
    }

    public String getHour19() {
        return hour19;
    }

    public void setHour19(String hour19) {
        this.hour19 = hour19;
    }

    public String getHour20() {
        return hour20;
    }

    public void setHour20(String hour20) {
        this.hour20 = hour20;
    }

    public String getHour21() {
        return hour21;
    }

    public void setHour21(String hour21) {
        this.hour21 = hour21;
    }

    public String getHour22() {
        return hour22;
    }

    public void setHour22(String hour22) {
        this.hour22 = hour22;
    }

    public String getHour23() {
        return hour23;
    }

    public void setHour23(String hour23) {
        this.hour23 = hour23;
    }

    public String getHour24() {
        return hour24;
    }

    public void setHour24(String hour24) {
        this.hour24 = hour24;
    }

    public void setId(String id) {
        this.id = id;

    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHour1() {
        return hour1;
    }

    public void setHour1(String hour1) {
        this.hour1 = hour1;
    }

    public String getyLong() {
        return yLong;
    }

    public void setyLong(String yLong) {
        this.yLong = yLong;
    }

    public String getxLong() {
        return xLong;
    }

    public void setxLong(String xLong) {
        this.xLong = xLong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHour3() {
        return hour3;
    }

    public void setHour3(String hour3) {
        this.hour3 = hour3;
    }

    public String getHour2() {
        return hour2;
    }

    public void setHour2(String hour2) {
        this.hour2 = hour2;
    }

    public String getHour6() {
        return hour6;
    }

    public void setHour6(String hour6) {
        this.hour6 = hour6;
    }

    public String getHour4() {
        return hour4;
    }

    public void setHour4(String hour4) {
        this.hour4 = hour4;
    }

    public String getHour5() {
        return hour5;
    }

    public void setHour5(String hour5) {
        this.hour5 = hour5;
    }

    public String getHour7() {
        return hour7;
    }

    public void setHour7(String hour7) {
        this.hour7 = hour7;
    }

    public String getHour8() {
        return hour8;
    }

    public void setHour8(String hour8) {
        this.hour8 = hour8;
    }

    public String getHour10() {
        return hour10;
    }

    public void setHour10(String hour10) {
        this.hour10 = hour10;
    }

    public String getHour9() {
        return hour9;
    }

    public void setHour9(String hour9) {
        this.hour9 = hour9;
    }

    public String getHour11() {
        return hour11;
    }

    public void setHour11(String hour11) {
        this.hour11 = hour11;
    }

    public String getHour12() {
        return hour12;
    }

    public void setHour12(String hour12) {
        this.hour12 = hour12;
    }

    public String getHour13() {
        return hour13;
    }

    public void setHour13(String hour13) {
        this.hour13 = hour13;
    }

    public String getHour14() {
        return hour14;
    }

    public void setHour14(String hour14) {
        this.hour14 = hour14;
    }
//
//    public static void main(String[] at) {
////        for(int i=1;i<=24;i++){
////            System.out.println("private String hour"+i+";");
////        }
//        Field[] declaredFields = LocationPeopleInfo.class.getDeclaredFields();
//        List<String> list= Lists.newArrayList();
//        for (Field field : declaredFields) {
//            String s = field.toString();
//            list.add(s.substring(s.lastIndexOf(".") + 1));
//        }
//        System.out.println(list.size());
//        String join = Joiner.on(",").join(list);
//        System.out.println(join);
//    }


    @Override
    public String toString() {
        return "LocationPeopleInfo{" +
                "index='" + index + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", xLong='" + xLong + '\'' +
                ", yLong='" + yLong + '\'' +
                ", hour1='" + hour1 + '\'' +
                ", hour2='" + hour2 + '\'' +
                ", hour3='" + hour3 + '\'' +
                ", hour4='" + hour4 + '\'' +
                ", hour5='" + hour5 + '\'' +
                ", hour6='" + hour6 + '\'' +
                ", hour7='" + hour7 + '\'' +
                ", hour8='" + hour8 + '\'' +
                ", hour9='" + hour9 + '\'' +
                ", hour10='" + hour10 + '\'' +
                ", hour11='" + hour11 + '\'' +
                ", hour12='" + hour12 + '\'' +
                ", hour13='" + hour13 + '\'' +
                ", hour14='" + hour14 + '\'' +
                ", hour15='" + hour15 + '\'' +
                ", hour16='" + hour16 + '\'' +
                ", hour17='" + hour17 + '\'' +
                ", hour18='" + hour18 + '\'' +
                ", hour19='" + hour19 + '\'' +
                ", hour20='" + hour20 + '\'' +
                ", hour21='" + hour21 + '\'' +
                ", hour22='" + hour22 + '\'' +
                ", hour23='" + hour23 + '\'' +
                ", hour24='" + hour24 + '\'' +
                '}';
    }
    private String[] getFieldArrays(){
        String[] strings = new String[31];
        strings[0]=index;
        strings[1]=id;
        strings[2]=type;
        strings[3]=name;
        return null;
    }
    public static void main(String[]args){
        Field[] declaredFields = LocationPeopleInfo.class.getDeclaredFields();
        Method[] methods = LocationPeopleInfo.class.getDeclaredMethods();
        for(Field field:declaredFields){
            System.out.println(field.toString());
        }
        for(Method method:methods){
            System.out.println(method.getName());
        }
    }

}
