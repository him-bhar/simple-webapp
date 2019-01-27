package com.himanshu.servlet3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface RequestProcessor {
  void process(HttpServletRequest request, HttpServletResponse response);
}
