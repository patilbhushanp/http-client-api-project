package com.httpclient.api;

import org.junit.Assert;
import org.junit.Test;

public class TestHttpClientModule {

    @Test
    public void shouldAbleConnect(){
        String url = "http://www.google.com/";
        HttpClientModule httpClientModule = new HttpClientModule();
        int responseCode = httpClientModule.connect(url);
        Assert.assertEquals(200, responseCode);
    }
}
