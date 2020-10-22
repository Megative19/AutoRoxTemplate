package Util;

import Bean.ResponseBody;
import Bean.ResponseBodyGuava;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;



import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

public class RequestHandler {

    public static ResponseBody doPost(String url) throws Exception {

        System.out.println("POST Request sent to service");
        System.out.println("At this date : " + new Date());
        System.out.println();
        String urlParams = ""; //request url parameters
        System.out.println("Request Body : " + urlParams);
        System.out.println();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .setHeader("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(urlParams))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        XmlMapper xmlMapper = new XmlMapper();
        ResponseBody value = xmlMapper.readValue(response.body(), ResponseBody.class);
        System.out.println("Response body : " + value.toString());
        return new ResponseBody(value.getSuccess(), value.getAmount(), value.getCurrency(),
                value.getMAC(), value.getPartnerId(), value.getLogin());

    }

    public static ResponseBodyGuava doGet(String url) throws Exception {
        System.out.println("GET Request sent to service");
        System.out.println("At this date : " + new Date());
        System.out.println();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response body: " + response.body());

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBodyGuava responseBodyGuava = objectMapper.readValue(response.body(), ResponseBodyGuava.class);
        return new ResponseBodyGuava(responseBodyGuava.getAvailable_amount());
    }


}
