package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HttpClientService implements HttpClient {


    private Response httpClient(String requestMethod, String url, Map<String, String> headers, byte[] payload) {
        Response response = new Response();
        try {
            URL testUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) testUrl.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod(requestMethod.toUpperCase(Locale.ROOT));
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            if (payload != null) connection.getOutputStream().write(payload);

            Scanner sc = new Scanner(connection.getInputStream());
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
            response.setPayload(sb.toString());
            response.setHeaders(headerTransformer(connection.getHeaderFields()));
            response.setStatusCode(connection.getResponseCode());
            response.setStatusText(connection.getResponseMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    private Map<String, String> headerTransformer(Map<String, List<String>> headerFields) {
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            map.put(entry.getKey(), entry.getValue().get(0));
        }
        return map;
    }

    @Override
    public Response get(String url, Map<String, String> headers) {
        return httpClient("get", url, headers, null);
    }

    @Override
    public Response post(String url, Map<String, String> headers, byte[] payload) {
        return httpClient("post", url, headers, payload);
    }

    @Override
    public Response post(String url, Map<String, String> headers, String payload) {
        return httpClient("post", url, headers, payload.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public Response put(String url, Map<String, String> headers, byte[] payload) {
        return httpClient("put", url, headers, payload);
    }

    @Override
    public Response put(String url, Map<String, String> headers, String payload) {
        return httpClient("put", url, headers, payload.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public Response delete(String url, Map<String, String> headers, byte[] payload) {
        return httpClient("delete", url, headers, payload);
    }

    @Override
    public Response delete(String url, Map<String, String> headers, String payload) {
        return httpClient("delete", url, headers, payload.getBytes(StandardCharsets.UTF_8));
    }


}
