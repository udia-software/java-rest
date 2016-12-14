package ca.udia.webapp;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

/**
 * Created by alexander on 2016-12-13.
 */
public class ApplicationServletTest extends Mockito {
    @Test
    public void testMainDoGet() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        PrintWriter writer = new PrintWriter("test.txt");
        when(response.getWriter()).thenReturn(writer);

        new ApplicationServlet().doGet(request, response);
        writer.flush();

        assertTrue("/ Returns Hello World!",
                Files.readAllLines(Paths.get("test.txt")).contains("Hello World!"));
    }
}
