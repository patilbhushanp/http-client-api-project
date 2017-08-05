package com.httpclient.api;

public class HttpArguments {
    private String url;
    private String method = "GET";

    public HttpArguments(String url, String method){
        this.url = url;
        this.method = method;
    }

    public HttpArguments(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }
}
