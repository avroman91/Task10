package org.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HttpClientService service = new HttpClientService();
        Response response = new Response();
        response = service.get("http://www.google.com",null);
        System.out.println(response);





//        Response response = new Response();
//        try {
//            URL url = new URL("http://www.google.com");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            connection.setRequestMethod("GET");
//            Map<String, List<String>> map = connection.getHeaderFields();
//            if (connection.getResponseCode() == 200){
//                Map<String,String> map1 = new HashMap<>();
//                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//                    map1.put(entry.getKey(),entry.getValue().get(0));
////                    System.out.println("Key : " + entry.getKey() + //получаем список заголовков
////                            " ,Value : " + entry.getValue());
//                }
//                response.setStatusCode(connection.getResponseCode());
//                response.setStatusText(connection.getResponseMessage());
//                response.setHeaders(map1);  // Тут вот вопрос, вообще пока не понятно что делать.
//                                            //Список хидеров мы получаем в формате Map<String, List<String>>. Не уж то переделывать List<String> на String?
//                response.setPayload(null);
//                System.out.println(response);
//
//            }



//            Scanner sc = new Scanner(connection.getInputStream());
//            response.setStatusCode(sc.nextInt());
//            response.setStatusText(sc.nextLine());
//            String headerLine= null;
//            Map<String,String > headersMap = new HashMap<>();
//            while (true){
//                headerLine = sc.nextLine();
//                if(headerLine.isEmpty()) break;
//                String[] headerParts = headerLine.split(": ");
//                headersMap.put(headerParts[0],headerParts[1]);
//            }
//            response.setHeaders(headersMap);
//            System.out.println(connection.getHeaderField(1));
//            Scanner sc = new Scanner(connection.getInputStream());
//            while (sc.hasNextLine()){
//                System.out.println(sc.nextLine());
//            }

//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
