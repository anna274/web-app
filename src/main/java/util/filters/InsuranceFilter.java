package util.filters;

import entity.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class InsuranceFilter extends Filter{
    private final Boolean withInsurance;

    public InsuranceFilter(Boolean hasInsurance) {
        this.withInsurance = hasInsurance;
    }

    @Override
    public List<Patient> apply(List<Patient> items) {
        return items.stream()
                .filter(patient -> withInsurance ? patient.getInsuranceNumber() != null : patient.getInsuranceNumber() == null)
                .collect(Collectors.toList());
    }
}
