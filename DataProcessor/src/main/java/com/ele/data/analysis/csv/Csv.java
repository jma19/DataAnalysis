package com.ele.data.analysis.csv;

import java.lang.annotation.*;

@Documented

@Retention(RetentionPolicy.RUNTIME)

@Target({ElementType.FIELD})
public @interface Csv {
    String value();

}