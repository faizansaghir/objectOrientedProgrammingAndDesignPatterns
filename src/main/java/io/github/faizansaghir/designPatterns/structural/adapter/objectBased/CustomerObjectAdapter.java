package io.github.faizansaghir.designPatterns.structural.adapter.objectBased;

import io.github.faizansaghir.designPatterns.structural.adapter.common.Customer;
import io.github.faizansaghir.designPatterns.structural.adapter.common.Employee;

// Adapter
public class CustomerObjectAdapter implements Customer {

    private final Employee employee;
    public CustomerObjectAdapter(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getName() {
        return employee.getFullName();
    }

    @Override
    public String getDesignation() {
        return employee.getJobTitle();
    }

    @Override
    public String getAddress() {
        return employee.getOfficeLocation();
    }
}
