// package com.pistech.joints.cookibook.snippet.java.runtime;

import java.util.Map;
import java.util.Iterator;
import java.util.Properties;

/**
 * 获取系统环境变量
 *
 * Created by Ray on 2016-09-20
 *
 * 描述：获取系统环境变量相关方法
*/
public class Env {
  public static void main(String [] args)
  {
    Map m = System.getenv();

    for ( Iterator it = m.keySet().iterator(); it.hasNext(); )
    {
      String key = (String ) it.next();
      String value = (String )  m.get(key);
      System.out.println(key +":" +value);
    }

    System.out.println( "--------------------------------------" );
    Properties p = System.getProperties();

    for ( Iterator it = p.keySet().iterator(); it.hasNext(); )
    {
      String key = (String ) it.next();
      String value = (String )  p.get(key);
      System.out.println(key +":" +value);
    }
  }
}