package com.himanshu.servlet3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

@DisplayName(value = "Running servlet initialization test")
public class ServletTest {
  @DisplayName("Check Junit5 running")
  @Test
  public void testSampleMethod() {
    Assertions.assertAll(() -> Assert.assertEquals("foo", "foo"));
  }
}
