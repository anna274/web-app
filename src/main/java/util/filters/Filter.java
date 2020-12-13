package util.filters;

import entity.Patient;

import java.util.List;

public abstract class Filter {
    private Filter nextFilter = null;

    protected abstract List<Patient> apply(List<Patient> items);

    public List<Patient> doChain(List<Patient> items) {
        List<Patient> result = apply(items);
        return nextFilter == null ? result : nextFilter.doChain(result);
    }

    public void setNextFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public static FilterBuilder builder() {
        return new FilterBuilder();
    }

    public static class FilterBuilder {
        private Filter firstFilter = null;
        private Filter lastFilter = null;

        public FilterBuilder addFilter(Filter filter) {
            if(firstFilter == null) {
                firstFilter = filter;
                lastFilter = filter;
                return this;
            }
            lastFilter.setNextFilter(filter);
            lastFilter = filter;
            return this;
        }

        public Filter build() {
            return firstFilter;
        }
    }
}
