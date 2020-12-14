import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class IndexServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher requestDispatcher;
    private IndexServlet servlet;

    @BeforeEach
    void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        servlet = new IndexServlet();
    }

    @AfterEach
    void tearDown() {
        request = null;
        response = null;
        servlet = null;
    }

    @Test
    void doGet() throws ServletException, IOException {
        Mockito.when(request.getParameter("fileName")).thenReturn("hospital");
        Mockito.when(request.getParameter("parser")).thenReturn("dom");
        Mockito.when(request.getRequestDispatcher("index.jsp")).thenReturn(requestDispatcher);
        servlet.doGet(request, response);
        Mockito.verify(request.getRequestDispatcher("index.jsp"));
    }
}