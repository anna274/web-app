package parsers;

import entity.Hospital;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DOMParserImplTest {
    private DOMParserImpl parser;

    @BeforeEach
    void setUp() {
        parser = new DOMParserImpl();
    }

    @AfterEach
    void tearDown() {
        parser = null;
    }

    @Test
    void parse() throws IOException, SAXException, ParserConfigurationException {
        Hospital hospital = parser.parse("hospital.xml");
        int excepted = 12;
        int actual = hospital.getHospitalPatients().size();
        assertEquals(excepted, actual);
    }
}