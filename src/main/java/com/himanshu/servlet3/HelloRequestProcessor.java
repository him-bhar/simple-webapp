package com.himanshu.servlet3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloRequestProcessor implements RequestProcessor {
  @Override
  public void process(HttpServletRequest req, HttpServletResponse resp) {
    try {
      String firstName = req.getParameter("fName");
      String lastName = req.getParameter("lName");
      if (firstName == null || lastName == null) {
        resp.getWriter().print("<html><body>");
        resp.getWriter().print("<p>Incomplete error string should be like: /hello?fName=John&lName=Doe</p>");
        resp.getWriter().print("</body></html>");
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return;
      }
      resp.getWriter().print("Welcome "+firstName+" "+lastName);
      resp.setStatus(HttpServletResponse.SC_OK);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}
