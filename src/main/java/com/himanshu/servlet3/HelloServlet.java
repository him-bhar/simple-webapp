package com.himanshu.servlet3;

import io.swagger.annotations.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SwaggerDefinition(
      info = @Info(
            description = "This is a sample server",
            version = "1.0.0",
            title = "Swagger Sample Servlet",
            termsOfService = "http://swagger.io/terms/",
            contact = @Contact(name = "Sponge-Bob", email = "apiteam@swagger.io", url = "http://swagger.io"),
            license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")
      ),
      /*consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"},*/
      schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
      tags = {@Tag(name = "users", description = "Operations about user")}
)
@Api(value = "/hello", description = "gets some data from a servlet")
@WebServlet(urlPatterns = {"/hello", "/simple"})
public class HelloServlet extends HttpServlet {
  private HelloRequestProcessor helloRequestProcessor;

  public HelloServlet() {
    super();
    this.helloRequestProcessor = new HelloRequestProcessor();
  }

  @ApiOperation(httpMethod = "GET", value = "Resource to greet a user", response = String.class, nickname = "")
  @ApiResponses({@ApiResponse(code = 400, message = "Invalid input", response = String.class)})
  @ApiImplicitParams({
        @ApiImplicitParam(name = "fName", value = "First name", required = true, /*dataType = "string",*/ paramType =
              "path"),
        @ApiImplicitParam(name = "lName", value = "Last name", required = true, /*dataType = "string",*/ paramType =
              "path")})
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.helloRequestProcessor.process(req, resp);
  }
}
