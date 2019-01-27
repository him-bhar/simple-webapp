package com.himanshu.servlet3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/hello", "/simple"})
public class HelloServlet extends HttpServlet {
  private HelloRequestProcessor helloRequestProcessor;

  public HelloServlet() {
    super();
    this.helloRequestProcessor = new HelloRequestProcessor();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.helloRequestProcessor.process(req, resp);
  }
}
