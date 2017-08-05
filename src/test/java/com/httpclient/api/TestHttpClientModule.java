package com.httpclient.api;

import org.junit.Assert;
import org.junit.Test;

public class TestHttpClientModule {

    @Test
    public void shouldAbleConnect(){
        String url = "http://www.google.com/";
        HttpClientModule httpClientModule = new HttpClientModule();
        int responseCode = httpClientModule.testConnection(new String[]{url});
        Assert.assertEquals(200, responseCode);
    }

    @Test
    public void shouldAbleToUnderstandMethodName(){
        String url = "http://www.google.com/";
        String methodArgument = "--method:GET";
        HttpClientModule httpClientModule = new HttpClientModule();
        int responseCode = httpClientModule.testConnection(new String[]{url, methodArgument});
        Assert.assertEquals(200, responseCode);
    }

    @Test
    public void shouldAbleToProcessPostContent(){
        String[] requestParameter = new String[]{"http://www.google.com/", "--m:POST='A new message'", "-h:Content-Type='application/text'"};
        HttpClientModule httpClientModule = new HttpClientModule();
        int responseCode = httpClientModule.testConnection(requestParameter);
        Assert.assertEquals(405, responseCode);
    }

    @Test
    public void shouldAbleToProcessPostRequestAlongWithMultipeHeader(){
        String[] requestParameter = new String[]{"http://www.google.com/", "--m:POST='A new message'", "-h:Accept='application/json',Content-Type='application/text'"};
        HttpClientModule httpClientModule = new HttpClientModule();
        int responseCode = httpClientModule.testConnection(requestParameter);
        Assert.assertEquals(405, responseCode);
    }
}
