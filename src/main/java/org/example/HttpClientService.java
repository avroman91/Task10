package org.example;

import java.util.Map;

public class HttpClientService implements HttpClient {

    Response response = new Response();

    @Override
    public Response get(String url, Map<String, String> headers) {
        return null;
    }

    @Override
    public Response post(String url, Map<String, String> headers, byte[] payload) {
        return null;
    }

    @Override
    public Response post(String url, Map<String, String> headers, String payload) {
        return null;
    }

    @Override
    public Response put(String url, Map<String, String> headers, byte[] payload) {
        return null;
    }

    @Override
    public Response put(String url, Map<String, String> headers, String payload) {
        return null;
    }

    @Override
    public Response delete(String url, Map<String, String> headers, byte[] payload) {
        return null;
    }

    @Override
    public Response delete(String url, Map<String, String> headers, String payload) {
        return null;
    }
}
