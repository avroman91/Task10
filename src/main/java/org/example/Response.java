package org.example;

import lombok.Data;

import java.util.Map;

@Data
public class Response {
    private String statusText;
    private int statusCode;
    private Map<String, String> headers;
    private String payload;

    @Override
    public String toString() {
        return "StatusText: " + statusText + "\n" +
                "statusCode: " + statusCode + "\n" +
                "Headers: " + headers + "\n" +
                "Payload: " + payload;
    }

}
