package com.httpclient.api;

public class ArgumentParser implements  Parser{
    public HttpRequestWrapper parseData(HttpRequestWrapper httpRequestWrapper, String[] arguments) {
        if(arguments.length == 1){
            httpRequestWrapper.setUrl(arguments[0]);
        }else if(arguments.length > 1){
            String methodArguments = arguments[1];
            if(methodArguments.startsWith("--method:") || methodArguments.startsWith("--m:")){
                String[] methodArgumentsArray = methodArguments.split(":");
                if(methodArgumentsArray.length == 2){
                    httpRequestWrapper.setUrl(arguments[0]);
                    String method = methodArgumentsArray[1].toUpperCase();
                    if(method.contains("POST=")){
                        httpRequestWrapper.setMethod("POST");
                        String[] payloadDataArray = methodArguments.split("=");
                        if(payloadDataArray.length == 2){
                            httpRequestWrapper.setPayloadData(payloadDataArray[1]);
                        }
                    }else {
                        httpRequestWrapper.setMethod(method);
                    }
                }
            }
        }
        return httpRequestWrapper;
    }
}
