package com.himanshu.servlet3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    System.out.println("Context created = [" + servletContextEvent.getServletContext().getContextPath() + "]");
    System.out.println("System.getProperty(\"my-system-property\") - "+System.getProperty("my-system-property"));
    System.out.println("System.getProperty(\"my-local-system-property\") - "+System.getProperty("my-local-system-property"));
  }

  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    System.out.println("Context destroyed = [" + servletContextEvent.getServletContext().getContextPath() + "]");
    System.out.println("System.getProperty(\"my-system-property\") - "+System.getProperty("my-system-property"));
    System.out.println("System.getProperty(\"my-local-system-property\") - "+System.getProperty("my-local-system-property"));
  }
}
