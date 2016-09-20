// package com.pistech.joints.cookibook.snippet.java.httpserver;

import java.io.InputStream; 
import java.io.IOException;

/**
 * 简单Http请求
 *
 * Created by Ray on 2016-09-20
 *
 * 描述：简单的Java Http请求
*/
public class SimpleHttpRequest {
  private InputStream input;
  private String uri;

  public SimpleHttpRequest(InputStream input) {
    this.input = input;
  }

  public void parse() {
    // Read a set of characters from the socket 
    StringBuffer request = new StringBuffer(2048); 
    int i;
    byte[] buffer = new byte[2048];

    try {
      i = input.read(buffer);
    } catch (IOException e) {
      e.printStackTrace();
      i = -1; 
    }

    for (int j=0; j<i; j++) { 
      request.append((char) buffer[j]);
    } 

    System.out.print(request.toString()); 
    uri = parseUri(request.toString());
  }

  private String parseUri(String requestString) {
    int index1, index2;
    index1 = requestString.indexOf(' ');

    if (index1 != -1) {
      index2 = requestString.indexOf(' ', index1 + 1);

      if (index2 > index1)
        return requestString.substring(index1 + 1, index2);
    }
    
    return null;
  }

  public String getUri() {
    return uri;
  }
}