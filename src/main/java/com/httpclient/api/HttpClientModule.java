package com.httpclient.api;

import org.apache.http.HttpConnection;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class HttpClientModule {
    HttpClient httpClient;

    public  HttpClientModule(){
        httpClient = HttpClientBuilder.create().build();
    }

    public int connect(String url) {
        HttpGet request = new HttpGet(url);
        int httpConnectionResponseCode = -1;
        try {
            HttpResponse response = httpClient.execute(request);
            httpConnectionResponseCode = response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpConnectionResponseCode;
    }
}
