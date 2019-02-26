package com.himanshu.swagger.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/*"}, filterName = "ApiOriginFilter")
public class ApiOriginFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
    final HttpServletResponse res = (HttpServletResponse) response;
    res.addHeader("Access-Control-Allow-Origin:", "*");
    res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    res.addHeader("Access-Control-Allow-Headers", "*");
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {

  }
}