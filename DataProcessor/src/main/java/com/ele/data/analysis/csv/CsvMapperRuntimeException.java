package com.ele.data.analysis.csv;

public class CsvMapperRuntimeException extends RuntimeException {
    static final long serialVersionUID = -7034897190745166939L;

    public CsvMapperRuntimeException() {
        super();
    }

    public CsvMapperRuntimeException(String s) {
        super(s);
    }

    public CsvMapperRuntimeException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CsvMapperRuntimeException(Throwable throwable) {
        super(throwable);
    }
}
