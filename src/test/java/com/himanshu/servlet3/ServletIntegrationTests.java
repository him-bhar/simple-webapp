package com.himanshu.servlet3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ServletIntegrationTests {
  private static String BASE_URI = "http://localhost:8080/web";
  private static String URI_PARAMS = "?fName=John&lName=Doe";
  @Test
  public void testHelloServletGet() throws IOException {
    String testUri = BASE_URI.concat("/hello").concat(URI_PARAMS);
    URL url = new URL(testUri);
    HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

    StringBuilder input = new StringBuilder();
    try(InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
        BufferedReader in = new BufferedReader(inputStreamReader)) {
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        System.out.println("inputLine = "+inputLine);
        input.append(inputLine);
      }
    }
    Assertions.assertAll(
          () -> Assert.assertTrue(HttpURLConnection.HTTP_OK == urlConnection.getResponseCode()),
          () -> Assert.assertTrue(input.toString().contains("Welcome John Doe"))
    );
  }

  @Test
  public void testHelloServletGetBadRequest() throws IOException {
    String testUri = BASE_URI.concat("/hello");
    URL url = new URL(testUri);
    HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
    Assertions.assertAll(
          () -> Assert.assertTrue(HttpURLConnection.HTTP_BAD_REQUEST == urlConnection.getResponseCode())
    );
  }

}
