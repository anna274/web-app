package parsers;

import entity.Department;
import entity.Hospital;
import entity.Patient;
import entity.Ward;
import util.filters.AgeFilter;
import util.filters.Filter;
import util.filters.InsuranceFilter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SAXParserImpl extends DefaultHandler implements Parser {
    private static final Hospital hospital = new Hospital();
    private static Department lastDepartment = null;
    private static Ward lastWard = null;

    @Override
    public Hospital parse(String fileName) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        SAXParserImpl.XMLHandler handler = new SAXParserImpl.XMLHandler();
        InputStream is = SAXParserImpl.class
                .getClassLoader()
                .getResourceAsStream(fileName);
        parser.parse(is, handler);

        return hospital;
    }


    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            if (qName.equals("hospital")) {
                String name = attributes.getValue("name");
                hospital.setName(name);
            }

            if (qName.equals("department")) {
                lastDepartment = new Department();
                String name = attributes.getValue("name");
                String phone = attributes.getValue("phone");
                lastDepartment.setName(name);
                lastDepartment.setPhone(phone);
            }
            if (qName.equals("ward")) {
                lastWard = new Ward();
                Integer placesNumber = Integer.parseInt(attributes.getValue("placesNumber"));
                Integer number  = Integer.parseInt(attributes.getValue("number"));
                String doctor = attributes.getValue("doctor");
                lastWard.setDoctor(doctor);
                lastWard.setNumber(number);
                lastWard.setPlacesNumber(placesNumber);
            }
            if (qName.equals("patient")) {
                Patient patient = new Patient();
                patient.setName(attributes.getValue("name"));
                patient.setAge(Integer.parseInt(attributes.getValue("age")));
                patient.setDiagnosis(attributes.getValue("diagnosis"));
                patient.setCovidStatus(attributes.getValue("covidStatus"));
                if(attributes.getValue("insuranceNumber") != null){
                    patient.setInsuranceNumber(attributes.getValue("insuranceNumber"));
                }
                lastWard.addPatient(patient);
            }

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("department")) {
                hospital.addDepartment(lastDepartment);
                lastDepartment = null;
            }
            if (qName.equals("ward")) {
                lastDepartment.addWard(lastWard);
                lastWard = null;
            }
        }

    }
}
