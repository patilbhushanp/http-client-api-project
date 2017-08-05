package com.httpclient.api;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestWrapper {
    private String url;
    private String method = "GET";
    private Map<String, String> headerMap = new HashMap<String, String>();
    private String payloadData;

    public String getUrl() {
        return url;
    }

    public String getPayloadData() {
        return payloadData;
    }

    public void setPayloadData(String payloadData) {
        this.payloadData = payloadData;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setHeaderMap(Map<String, String> headerMap) {
        this.headerMap = headerMap;
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }
}
