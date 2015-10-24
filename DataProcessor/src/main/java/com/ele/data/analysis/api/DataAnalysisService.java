package com.ele.data.analysis.api;

import java.util.Date;
import java.util.List;

/**
 * Created by majun on 15/10/23.
 */
public interface DataAnalysisService<T> {
    List<T> getTopNList(Date date,int n);
    List<T> getWarningLocationList(Date date);
}
