package com.httpclient.api;

import org.junit.Assert;
import org.junit.Test;

public class TestArgumentParser {
    @Test
    public void argumentShouldAbletoParseWithUriAndMethodName(){
        String url = "http://www.google.com/";
        String methodArgument = "--method:GET";
        HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper();
        ArgumentParser argumentParser = new ArgumentParser();
        argumentParser.parseData(httpRequestWrapper, new String[]{url, methodArgument});
        Assert.assertEquals(url, httpRequestWrapper.getUrl());
        Assert.assertEquals("GET", httpRequestWrapper.getMethod());
    }
}
