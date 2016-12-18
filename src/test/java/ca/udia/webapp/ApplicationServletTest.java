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
        assertTrue("True is True", true);
    }
}
