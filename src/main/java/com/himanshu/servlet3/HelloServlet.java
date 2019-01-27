package com.himanshu.servlet3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/hello", "/simple"})
public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
    return;
  }
}
