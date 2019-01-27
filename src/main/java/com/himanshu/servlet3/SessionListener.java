package com.himanshu.servlet3;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
  public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    System.out.println("Created session = [" + httpSessionEvent.getSession().getId() + "]");
  }

  public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    System.out.println("Destroyed session = [" + httpSessionEvent.getSession().getId() + "]");
  }
}
