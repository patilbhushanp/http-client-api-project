package com.httpclient.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HttpHeaderArguments {
    Map<String, String> headerValueMap = new ConcurrentHashMap<String, String>();

    public String getContentType() {
        return headerValueMap.get("Content-Type");
    }

    public void addHeaderField(String property, String value){
        headerValueMap.put(property, value);
    }
}
