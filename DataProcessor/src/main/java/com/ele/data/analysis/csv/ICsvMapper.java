package com.ele.data.analysis.csv;

import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Map;


public interface ICsvMapper<T> {
    ICsvMapper<T> withMapping(Map<String, String> mapping);

    ICsvMapper<T> withMapping(ICsvColumnMapping mapping);

    ICsvMapper<T> withMapping(String header, String property);

    List<T> fromCsv(Reader reader);

    void toCsv(Writer writer, List<T> list) throws Exception;
}
