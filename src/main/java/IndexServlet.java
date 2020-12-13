import entity.Hospital;
import entity.Patient;
import parsers.Parser;
import parsers.ParserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/*")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
        String parserName = req.getParameter("parser");
        if(fileName != null && parserName != null) {
            Parser parser = ParserType.getParserByName(parserName);
            try {
                Hospital hospital = parser.parse(fileName + ".xml");
                List<Patient> patients = hospital.getHospitalPatients();
                req.setAttribute("patients", patients);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
