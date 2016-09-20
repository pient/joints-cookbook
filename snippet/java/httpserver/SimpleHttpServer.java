// package com.pistech.joints.cookibook.snippet.java.httpserver;

import java.net.Socket; 
import java.net.ServerSocket; 
import java.net.InetAddress; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 
import java.io.File;

/**
 * 简单Http服务端
 *
 * Created by Ray on 2016-09-20
 *
 * 描述：简单的Java Http服务端
*/
public class SimpleHttpServer {
  /** WEB_ROOT is the directory where our HTML and other files reside. * For this package, WEB_ROOT is the "webroot" directory under the
  * working directory.
  * The working directory is the location in the file system
  * from where the java command was invoked.
  */
  public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

  // shutdown command
  private static final String SHUTDOWN_COMMAND = "/SHUTDOWN"; // the shutdown command received

  private boolean shutdown = false;

  public static void main(String[] args) {
    SimpleHttpServer server = new SimpleHttpServer();
    server.await();
  }

  public void await() {
    ServerSocket serverSocket = null; 
    int port = 8080;

    try {
      serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1")); 
    } catch (IOException e) { 
      e.printStackTrace(); 
      System.exit(1);
    }

    // Loop waiting for a request 
    while (!shutdown) {
      Socket socket = null; 
      InputStream input = null; 
      OutputStream output = null; 

      try {
        socket = serverSocket.accept();
        input = socket.getInputStream(); 
        output = socket.getOutputStream();

        // create Request object and parse 
        SimpleHttpRequest request = new SimpleHttpRequest(input); 
        request.parse();

        // create Response object
        SimpleHttpResponse response = new SimpleHttpResponse(output); 
        response.setRequest(request); 
        response.sendStaticResource();

        // Close the socket
        socket.close();

        //check if the previous URI is a shutdown command 
        shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
      } catch (Exception e) {
        e.printStackTrace ();
        continue;
      }
    }
  }
}