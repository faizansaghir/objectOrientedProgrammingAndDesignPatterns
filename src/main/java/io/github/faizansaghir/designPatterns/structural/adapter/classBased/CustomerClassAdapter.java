package io.github.faizansaghir.designPatterns.structural.adapter.classBased;

import io.github.faizansaghir.designPatterns.structural.adapter.common.Customer;
import io.github.faizansaghir.designPatterns.structural.adapter.common.Employee;

// Adapter
public class CustomerClassAdapter extends Employee implements Customer {
    @Override
    public String getName() {
        return this.getFullName();
    }

    @Override
    public String getDesignation() {
        return this.getJobTitle();
    }

    @Override
    public String getAddress() {
        return this.getOfficeLocation();
    }
}
