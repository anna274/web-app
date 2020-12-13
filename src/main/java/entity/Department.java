package entity;

import java.util.ArrayList;

public class Department {
    private String name;
    private String phone;
    private ArrayList<Ward> wards = new ArrayList<>();

    public Department(){}

    public Department(String name, String phone, ArrayList<Ward> wards) {
        this.name = name;
        this.phone = phone;
        this.wards = wards;
    }

    public Department(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public static DepartmentBuilder builder() {
        return new DepartmentBuilder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Ward> getWards() {
        return wards;
    }

    public void setWards(ArrayList<Ward> wards) {
        this.wards = wards;
    }

    public void addWard(Ward ward) {
        wards.add(ward);
    }

    public ArrayList<Patient> getDepartmentPatients() {
        ArrayList<Patient> departmentPatients = new ArrayList<>();
        for(Ward ward: wards) {
            departmentPatients.addAll(ward.getPatients());
        }
        return departmentPatients;
    }

    public static class DepartmentBuilder {
        private String name;
        private String phone;
        private ArrayList<Ward> wards;

        DepartmentBuilder() {
        }

        public DepartmentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DepartmentBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public DepartmentBuilder wards(ArrayList<Ward> wards) {
            this.wards = wards;
            return this;
        }

        public Department build() {
            return new Department(name, phone, wards);
        }

        public String toString() {
            return "Department.DepartmentBuilder(name=" + this.name + ", phone=" + this.phone + ", wards=" + this.wards + ")";
        }
    }
}
