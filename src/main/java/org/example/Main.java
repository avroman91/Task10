package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HttpClientService service = new HttpClientService();
        Response response;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "text/html");

        response = service.get("http://www.google.com", headers);
        System.out.println(response);

    }
}
