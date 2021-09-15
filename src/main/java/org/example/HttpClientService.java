package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class HttpClientService implements HttpClient {

    private Response response = new Response();
    private HttpURLConnection connection= null;

    private void connect (String url, String requestMethod){
        try {
            URL newUrl = new URL(url);
            connection = (HttpURLConnection) newUrl.openConnection();
            connection.setRequestMethod(requestMethod.toUpperCase(Locale.ROOT));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }

    private Map<String,String> headerTransformer(Map<String,List<String>> headerFields){
        Map<String,String> map = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            map.put(entry.getKey(), entry.getValue().get(0));
        }
        return map;
    }

    @Override
    public Response get(String url, Map<String, String> headers) {
        connect(url,"GET");
        try {
            response.setStatusText(connection.getResponseMessage());
            response.setStatusCode(connection.getResponseCode());
            response.setHeaders(headerTransformer(connection.getHeaderFields()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
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
