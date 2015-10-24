package com.ele.data.analysis.api;

import java.util.Date;
import java.util.List;

public interface DataAnalysisService<T> {
    List<T> getTopNList(Date date,int n);
    List<T> getWarningLocationList(Date date,int threshold);
}
