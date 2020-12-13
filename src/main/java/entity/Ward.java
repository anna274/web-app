package entity;

import java.util.ArrayList;

public class Ward {
    private Integer number;
    private String doctor;
    private Integer placesNumber;
    private ArrayList<Patient> patients = new ArrayList<>();

    public Ward() {
    }

    public Ward(Integer number, String doctor, Integer placesNumber, ArrayList<Patient> patients) {
        this.number = number;
        this.doctor = doctor;
        this.placesNumber = placesNumber;
        this.patients = patients;
    }

    public static WardBuilder builder() {
        return new WardBuilder();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Integer getPlacesNumber() {
        return placesNumber;
    }

    public void setPlacesNumber(Integer placesNumber) {
        this.placesNumber = placesNumber;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public static class WardBuilder {
        private Integer number;
        private String doctor;
        private Integer placesNumber;
        private ArrayList<Patient> patients;

        WardBuilder() {
        }

        public WardBuilder number(Integer number) {
            this.number = number;
            return this;
        }

        public WardBuilder doctor(String doctor) {
            this.doctor = doctor;
            return this;
        }

        public WardBuilder placesNumber(Integer placesNumber) {
            this.placesNumber = placesNumber;
            return this;
        }

        public WardBuilder patients(ArrayList<Patient> patients) {
            this.patients = patients;
            return this;
        }

        public Ward build() {
            return new Ward(number, doctor, placesNumber, patients);
        }

        public String toString() {
            return "Ward.WardBuilder(number=" + this.number + ", doctor=" + this.doctor + ", placesNumber=" + this.placesNumber + ", patients=" + this.patients + ")";
        }
    }
}
