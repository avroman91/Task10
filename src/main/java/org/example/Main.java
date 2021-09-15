package org.example;

public class Main {
    public static void main(String[] args) {
        HttpClientService service = new HttpClientService();
        Response response = new Response();
        response = service.get("http://www.google.com",null);
        System.out.println(response);


    }
}
