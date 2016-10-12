// package com.pistech.joints.cookibook.snippet.java.httpserver;

import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * 简单Http客户端
 *
 * Created by Ray on 2016-09-20
 *
 * 描述：简单的Java Http客户端
*/
public class SimpleHttpClient {
  public static void main(String [] args)
  {
    try {
      Socket socket = new Socket("127.0.0.1", 8080); 
      OutputStream os = socket.getOutputStream(); 
      boolean autoflush = true;
      PrintWriter out = new PrintWriter( socket.getOutputStream(), autoflush); 
      BufferedReader in = new BufferedReader(
        new InputStreamReader( socket.getInputStream() )); 

      // send an HTTP request to the web server 
      out.println("GET /index.jsp HTTP/1.1"); 
      out.println("Host: localhost:8080"); 
      out.println("Connection: Close");
      out.println();

      // read the response
      boolean loop = true;
      StringBuffer sb = new StringBuffer(8096); 
      while (loop) {
        if ( in.ready() ) { 
          int i=0;
          while (i!=-1) {
            i = in.read();
            sb.append((char) i); 
          }
          loop = false;
        }

        Thread.currentThread().sleep(50);
      }

      // display the response to the out console 
      System.out.println(sb.toString()); 
      socket.close();
    } catch (UnknownHostException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}