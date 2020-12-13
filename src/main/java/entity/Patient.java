package entity;

public class Patient{
    private String name;
    private Integer age;
    private String diagnosis;
    private String insuranceNumber;
    private String covidStatus;

    public Patient(){}

    public Patient(String name, Integer age, String diagnosis, String insuranceNumber, String covidStatus) {
        this.name= name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.insuranceNumber = insuranceNumber;
        this.covidStatus = covidStatus;
    }

    public static PatientBuilder builder() {
        return new PatientBuilder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getCovidStatus() {
        return covidStatus;
    }

    public void setCovidStatus(String covidStatus) {
        this.covidStatus = covidStatus;
    }

    public static class PatientBuilder {
        private String name;
        private Integer age;
        private String diagnosis;
        private String insuranceNumber;
        private String covidStatus;

        PatientBuilder() {
        }

        public PatientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PatientBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public PatientBuilder diagnosis(String diagnosis) {
            this.diagnosis = diagnosis;
            return this;
        }

        public PatientBuilder insuranceNumber(String insuranceNumber) {
            this.insuranceNumber = insuranceNumber;
            return this;
        }

        public PatientBuilder covidStatus(String covidStatus) {
            this.covidStatus = covidStatus;
            return this;
        }

        public Patient build() {
            return new Patient(name, age, diagnosis, insuranceNumber, covidStatus);
        }

        public String toString() {
            return "Patient.PatientBuilder(name=" + this.name + ", age=" + this.age + ", diagnosis=" + this.diagnosis + ", insuranceNumber=" + this.insuranceNumber + ", covidStatus=" + this.covidStatus + ")";
        }
    }
}
