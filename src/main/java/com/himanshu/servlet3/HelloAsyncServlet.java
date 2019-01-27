package com.himanshu.servlet3;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/async/hello"}, asyncSupported = true)
public class HelloAsyncServlet extends HttpServlet {
  private HelloRequestProcessor helloRequestProcessor;

  public HelloAsyncServlet() {
    super();
    this.helloRequestProcessor = new HelloRequestProcessor();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    AsyncContext asyncContext = req.startAsync(req, resp);
    asyncContext.setTimeout(10000l);
    asyncContext.addListener(new AsyncListener() {
      @Override
      public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Completed!");
      }

      @Override
      public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Timed out!");
        asyncContext.getResponse().getWriter().write("TIMEOUT");
        asyncContext.complete();
      }

      @Override
      public void onError(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Errored!");
      }

      @Override
      public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Async Started!");
      }
    });
    processRequest(asyncContext);
    System.out.println("Request processed!");
  }

  private void processRequest(AsyncContext asyncContext) {
    Runnable r = () -> {
      this.helloRequestProcessor.process((HttpServletRequest) asyncContext.getRequest(), (HttpServletResponse) asyncContext.getResponse());
      asyncContext.complete();
    };
    new Thread(r).start();
  }

}
