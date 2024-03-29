package com.narakeet;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.entity.ByteArrayEntity;
import java.nio.charset.StandardCharsets;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class Example {
  public static void main(String[] args) throws java.io.FileNotFoundException, java.io.IOException {

    String apiKey = Objects.requireNonNull(System.getenv("NARAKEET_API_KEY"), "NARAKEET_API_KEY environment variable is not set");

    String voice = "brian";
    String text = "Hello from Java!";

    String url = String.format("https://api.narakeet.com/text-to-speech/mp3?voice=%s", voice);
    String outputFilePath = "output.mp3";

    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost httpPost = new HttpPost(url);
    httpPost.setHeader("Accept", "application/octet-stream");
    httpPost.setHeader("Content-Type", "text/plain");
    httpPost.setHeader("x-api-key", apiKey);

    byte[] utf8Bytes = text.getBytes(StandardCharsets.UTF_8);
    ByteArrayEntity requestBody = new ByteArrayEntity(utf8Bytes);
    httpPost.setEntity(requestBody);

    FileOutputStream outputStream = new FileOutputStream(outputFilePath);
    HttpResponse response = httpClient.execute(httpPost);
    response.getEntity().writeTo(outputStream);
    outputStream.close();
  }
}

