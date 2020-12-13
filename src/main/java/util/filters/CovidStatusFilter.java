package util.filters;

import entity.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class CovidStatusFilter extends Filter{
    private final String status;

    public CovidStatusFilter(String status) {
        this.status = status;
    }

    @Override
    public List<Patient> apply(List<Patient> items) {
        return items.stream()
                .filter(item -> item.getCovidStatus().equals(status))
                .collect(Collectors.toList());
    }
}
