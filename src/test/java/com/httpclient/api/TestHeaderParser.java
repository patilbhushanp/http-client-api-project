package com.httpclient.api;

import org.junit.Assert;
import org.junit.Test;

public class TestHeaderParser {
    @Test
    public void shouldHaveValidHeader(){
        String headerField = "-h:Content-Type=‘application/text’";
        HeaderParser headerParser = new HeaderParser();
        HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper();
        httpRequestWrapper = headerParser.parseData(httpRequestWrapper, new String[]{headerField});
        Assert.assertEquals("‘application/text’", httpRequestWrapper.getHeaderMap().get("Content-Type"));
    }
}
