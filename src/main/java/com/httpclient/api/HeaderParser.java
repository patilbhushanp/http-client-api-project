package com.httpclient.api;

import java.util.HashMap;
import java.util.Map;

public class HeaderParser implements  Parser{

    public HttpRequestWrapper parseData(HttpRequestWrapper httpRequestWrapper, String[] arguments){
        for(String headerRawData : arguments){
            if(headerRawData.startsWith("-h:")){
                String[] headerRawDataArray = headerRawData.split(":");
                if(headerRawDataArray.length == 2) {
                    String headerData = headerRawDataArray[1];
                    httpRequestWrapper.setHeaderMap(parseMultipleHeader(headerData, new HashMap<String, String>()));
                }
            }
        }
        return httpRequestWrapper;
    }

    private Map<String, String> parseMultipleHeader(String headerData, Map<String, String> headerMap){
        if(headerData.contains(";")){
            parseMultipleHeader(headerData.substring(headerData.indexOf(";") + 1), headerMap);
        }
        String[] contentTypeDataValueArray = headerData.split("=");
        if(contentTypeDataValueArray.length == 2){
            headerMap.put(contentTypeDataValueArray[0], contentTypeDataValueArray[1]);
        }
        return headerMap;
    }
}
