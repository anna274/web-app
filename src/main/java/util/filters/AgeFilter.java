package util.filters;

import entity.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class AgeFilter extends Filter {
    private final int minAge;
    private final int maxAge;

    public AgeFilter(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public List<Patient> apply(List<Patient> items) {
        return items.stream()
                .filter(item -> item.getAge() >= minAge && item.getAge() <= maxAge)
                .collect(Collectors.toList());
    }
}
