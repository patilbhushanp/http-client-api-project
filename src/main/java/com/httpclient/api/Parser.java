package com.httpclient.api;

public interface Parser {
   HttpRequestWrapper parseData(HttpRequestWrapper httpRequestWrapper, String[] arguments);
}
