package entity;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String name;
    private ArrayList<Department> departments = new ArrayList<>();

    public Hospital(){}

    public Hospital(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }

    public Hospital(String name, ArrayList<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    public static HospitalBuilder builder() {
        return new HospitalBuilder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Patient> getHospitalPatients() {
        ArrayList<Patient> hospitalPatients = new ArrayList<>();
        for(Department department: departments) {
            hospitalPatients.addAll(department.getDepartmentPatients());
        }
        return hospitalPatients;
    }

    public static class HospitalBuilder {
        private String name;
        private ArrayList<Department> departments;

        HospitalBuilder() {
        }

        public HospitalBuilder name(String name) {
            this.name = name;
            return this;
        }

        public HospitalBuilder departments(ArrayList<Department> departments) {
            this.departments = departments;
            return this;
        }

        public Hospital build() {
            return new Hospital(name, departments);
        }

        public String toString() {
            return "Hospital.HospitalBuilder(name=" + this.name + ", departments=" + this.departments + ")";
        }
    }
}
