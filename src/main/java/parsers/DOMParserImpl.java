package parsers;

import entity.Department;
import entity.Hospital;
import entity.Patient;
import entity.Ward;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DOMParserImpl implements Parser {
    @Override
    public Hospital parse(String fileName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream is = DOMParserImpl.class
                .getClassLoader()
                .getResourceAsStream(fileName);
        Document document = builder.parse(is);
        Element root = document.getDocumentElement();

        NodeList nodeList = root.getElementsByTagName("hospital");
        return IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item)
                .map(node -> parseHospitalElement((Element) node))
                .collect(Collectors.toList()).get(0);
    }

    private Hospital parseHospitalElement(Element hospitalElement) {
        NamedNodeMap attributes = hospitalElement.getAttributes();
        Hospital hospital = Hospital.builder()
                .name(attributes.getNamedItem("name").getNodeValue())
                .departments(new ArrayList<>())
                .build();

        NodeList departmentNodes = hospitalElement.getElementsByTagName("department");
        IntStream.range(0, departmentNodes.getLength())
                .mapToObj(i -> parseDepartmentElement((Element) departmentNodes.item(i)))
                .forEach(hospital::addDepartment);
        return hospital;
    }

    private Department parseDepartmentElement(Element departmentElement) {
        NamedNodeMap attributes = departmentElement.getAttributes();
        Department department = Department.builder()
                .name(attributes.getNamedItem("name").getNodeValue())
                .phone(attributes.getNamedItem("phone").getNodeValue())
                .wards(new ArrayList<>())
                .build();

        NodeList wardsNodes = departmentElement.getElementsByTagName("ward");
        IntStream.range(0, wardsNodes.getLength())
                .mapToObj(i -> parseWardElement((Element) wardsNodes.item(i)))
                .forEach(department::addWard);
        return department;
    }

    private Ward parseWardElement(Element wardNode) {
        NamedNodeMap attributes = wardNode.getAttributes();
        Ward ward = Ward.builder()
                .number(Integer.parseInt(attributes.getNamedItem("number").getNodeValue()))
                .placesNumber(Integer.parseInt(attributes.getNamedItem("placesNumber").getNodeValue()))
                .doctor(attributes.getNamedItem("doctor").getNodeValue())
                .patients(new ArrayList<>())
                .build();

        NodeList patientNodes = wardNode.getElementsByTagName("patient");
        IntStream.range(0, patientNodes.getLength())
                .mapToObj(i -> parsePatientElement((Element) patientNodes.item(i)))
                .forEach(ward::addPatient);
        return ward;
    }

    private Patient parsePatientElement(Element patientNode) {
        NamedNodeMap attributes = patientNode.getAttributes();
        Patient patient = Patient.builder()
                .name(attributes.getNamedItem("name").getNodeValue())
                .age(Integer.parseInt(attributes.getNamedItem("age").getNodeValue()))
                .diagnosis(attributes.getNamedItem("diagnosis").getNodeValue())
                .covidStatus(attributes.getNamedItem("covidStatus").getNodeValue())
                .build();
        Node insuranceNumberNode = attributes.getNamedItem("insuranceNumber");
        if(insuranceNumberNode != null) {
            patient.setInsuranceNumber(insuranceNumberNode.getNodeValue());
        }
        return patient;
    }
}
