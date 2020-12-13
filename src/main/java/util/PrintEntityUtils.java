package util;

import entity.Department;
import entity.Hospital;
import entity.Patient;
import entity.Ward;

public class PrintEntityUtils {
    public static void printHospitalInfo(Hospital hospital) {
        System.out.println("Hospital: " + hospital.getName() + ", departments:");
        hospital.getDepartments().forEach(PrintEntityUtils::printDepartmentInfo);
    }
    public static void printDepartmentInfo(Department department) {
        System.out.println("Department '" + department.getName() + "', phone = " + department.getPhone() + ", wards:");
        department.getWards().forEach(PrintEntityUtils::printWardInfo);
    }

    public static void printWardInfo(Ward ward) {
        System.out.println("Ward № '" + ward.getNumber() + "', doctor = " + ward.getDoctor() + ", patients:");
        ward.getPatients().forEach(PrintEntityUtils::printPatientInfo);
    }

    public static void printPatientInfo(Patient patient) {
        System.out.println(
                "Patient: " +
                        "name='" + patient.getName() + '\'' +
                        ", age=" + patient.getAge() +
                        ", diagnosis='" + patient.getDiagnosis() + '\'' +
                        ", insuranceNumber=" + patient.getInsuranceNumber() +
                        ", covidStatus='" + patient.getCovidStatus());
    }
}
