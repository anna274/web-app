package parsers;

import entity.Hospital;
import entity.Patient;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface Parser {
    Hospital parse(String fileName) throws ParserConfigurationException, SAXException, IOException;
}
