package com.httpclient.api;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Iterator;

public class HttpClientModule {
    HttpClient httpClient;

    public static void main(String[] args){
        testConnection(args);
    }

    public static int testConnection(String[] args){
        int httpConnectionResponseCode = -1;
        Parser[] parsers= new Parser[]{new ArgumentParser(), new HeaderParser()};
        HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper();
        for(Parser parser : parsers){
            parser.parseData(httpRequestWrapper, args);
        }

        if("".equals(httpRequestWrapper.getUrl()) == false) {
            HttpClientModule httpClientModule = new HttpClientModule();
            httpConnectionResponseCode = httpClientModule.connect(httpRequestWrapper);
            System.out.print("URL : " + httpRequestWrapper.getUrl() + " Response : (" + httpConnectionResponseCode + ")");
        }
        return httpConnectionResponseCode;
    }

    public  HttpClientModule(){
        httpClient = HttpClientBuilder.create().build();
    }

    public int connect(HttpRequestWrapper httpRequestWrapper) {
        HttpUriRequest httpRequest = new HttpGet(httpRequestWrapper.getUrl());
        if(httpRequestWrapper.getMethod().equalsIgnoreCase("GET")){
            httpRequest = new HttpGet(httpRequestWrapper.getUrl());
        }else if(httpRequestWrapper.getMethod().equalsIgnoreCase("POST")){
            httpRequest = new HttpPost(httpRequestWrapper.getUrl());
        }
        Iterator<String> headerMapIterator = httpRequestWrapper.getHeaderMap().keySet().iterator();
        while(headerMapIterator.hasNext()){
            String property = headerMapIterator.next();
            String value = httpRequestWrapper.getHeaderMap().get(property);
            httpRequest.setHeader(property, value);
        }
        int httpConnectionResponseCode = -1;
        try {
            HttpResponse response = httpClient.execute(httpRequest);
            httpConnectionResponseCode = response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpConnectionResponseCode;
    }
}
